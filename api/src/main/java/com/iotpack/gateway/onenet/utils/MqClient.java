package com.iotpack.gateway.onenet.utils;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class MqClient {
    private MqttConnectOptions options = new MqttConnectOptions();

    private MqttClient client;
    /**
     * 是否需要手动回复ack
     */
    private boolean manualAcks = false;

    private String subTopic;

    public boolean getManualAcks() {
        return manualAcks;
    }

    public void messageArrivedComplete(MqttMessage msg) {
        try {
            client.messageArrivedComplete(msg.getId(), msg.getQos());
        } catch (MqttException e) {
            System.out.println("send puback catch exception");
            e.printStackTrace();
        }
    }

    public synchronized boolean connect() {

        String clientID = "testonenet"; //用户自定义合法的UTF-8字符串，可为空
        String serverURI = "ssl://183.230.40.96:8883";
        String userName = "testonenet"; //MQID

        String mqTopic = "test"; //mq topic
        String mqSub = "testBtn"; // mq sub

        try {
            if (null == client) {
                client = new MqttClient(serverURI, clientID, new MemoryPersistence());
            }
            //获取连接配置
            client.setManualAcks(manualAcks);
            client.setCallback(new PushCallback(this));
            resetOptions();
            try {
                client.connect(options);
            } catch (MqttException e) {
                e.printStackTrace();
            }
            subTopic = String.format("$sys/pb/consume/%s/%s/%s", userName, mqTopic, mqSub);

            try {
                //订阅 topic $sys/pb/consume/$MQ_ID/$TOPIC/$SUB ，QoS必须大于0，否则订阅失败
                client.subscribe(subTopic, 1);
                System.out.println("sub success");
                return true;
            } catch (MqttException e) {
                System.out.println("sub failed");
                e.printStackTrace();
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void resetOptions() {
        String userName = "testonenet"; //MQID
        String accessKey = "WUbSPXkX25LJY4L/GKQILG1b9CBiAjAGcYEQEBXaGbo="; //mq access_key

        String version = "2018-10-31"; //版本号，无需修改
        String resourceName = "mqs/" + userName;  //通过MQ实例名称访问MQ
        String expirationTime = System.currentTimeMillis() / 1000 + 100 * 24 * 60 * 60 + "";
        String signatureMethod = "md5";  //签名方法，支持md5、sha1、sha256
        String password = null;
        try {
            //生成token
            password = Token.assembleToken(version, resourceName, expirationTime, signatureMethod, accessKey);
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        options.setCleanSession(true); //clean session 必须设置 true
        options.setUserName(userName);
        options.setPassword(password.toCharArray());
        options.setConnectionTimeout(20);
        options.setKeepAliveInterval(30);
        options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);
        InputStream caCrtFile = null;
        try {
            caCrtFile = new File("/var/data/ssl/MQ-certificate-release-0711.pem").toURL().openStream();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            options.setSocketFactory(SslUtil.getSocketFactory(caCrtFile));
        } catch (NoSuchAlgorithmException | KeyStoreException | CertificateException
                | IOException | KeyManagementException e) {
            e.printStackTrace();
        }
    }

    public boolean reConnect() {
        if (null != client) {
            try {
                if (!client.isConnected()) { //订阅失败而导致重连是不需要重新连接
                    resetOptions();//防止token过期，需重新设置
                    client.connect(options);
                }
                client.subscribe(subTopic, 1);//订阅失败会抛异常
                System.out.println("reconncet and sub ok");
                return true;
            } catch (Exception e) {//订阅和连接失败都会进到此异常中
                System.out.println("reconnect failed");
                e.printStackTrace();//由于在循环中调用，建议调试时打印堆栈信息，正式中此打印删除
                return false;
            }
        } else {
            return connect();
        }
    }

    public static void main() {
        MqClient mqClient = new MqClient();
        mqClient.connect();
    }
}
