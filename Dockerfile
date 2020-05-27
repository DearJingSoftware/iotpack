FROM registry.cn-beijing.aliyuncs.com/cpx/alpine-java:jdk8

ADD bin/iotpack.jar iotpack.jar
ENV JAVA_HOME=/usr/lib/jvm/default-jvm
ENV PATH=$JAVA_HOME/bin:$PATH
ENV CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
ENV JAVA_OPTS="-Xms1024m -XX:PermSize=512m -XX:MaxPermSize=256m -XX:MaxNewSize=128m  -Dapollo.bootstrap.enabled=true -Dapollo.configService=http://config.cloud.chupinxiu.com -Dapollo.meta=http://config.cloud.chupinxiu.com -Dapp.id=100013 -Dapollo.cluster=prod"
EXPOSE 8080
ENTRYPOINT java  ${JAVA_OPTS}  -jar /iotpack.jar