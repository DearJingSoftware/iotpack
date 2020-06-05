import 'package:flutter/material.dart';
import 'package:iotpack/init/initHive.dart';
import 'package:iotpack/pages/home.dart';
import 'package:iotpack/route.dart';

void main() async {
  //设置高德地图ioskey
  InitHive();
//
//  final client = MqttServerClient('broker.emqx.io', 'iotpackTest');
//  client.onConnected = () {
//    print("mqtt链接成功");
//
//    client.subscribe("/iotpack", MqttQos.exactlyOnce);
//    client.updates.listen((List<MqttReceivedMessage<MqttMessage>> event) {
//      final MqttPublishMessage recMess = event[0].payload;
//      final pt =
//          MqttPublishPayload.bytesToStringAsString(recMess.payload.message);
//      print(pt);
//    });
//
//    typed.Uint8Buffer data = new typed.Uint8Buffer();
//    data.add(1);
//    data.add(2);
//    client.publishMessage("/iotpack", MqttQos.exactlyOnce, data);
//  };
//
//  client.onSubscribeFail = (s) {
//    print("订阅失败");
//    print(s);
//  };
//
//  await client.connect();
//
//  final database =
//      await $FloorAppDatabase.databaseBuilder('app_database.db').build();
//  final deviceDao = database.deviceDao;
//
////  final device = Device(1, 'Frank');
////  await deviceDao.insertDevice(device);
//
//  final result = await deviceDao.findDeviceById(1);
//  result.first.then((value) => {print(value.name)});

//  print("加载配置文件");
//  await DotEnv().load('.env').catchError((e) {
//    print("加载配置文件出错");
//    print(e.toString());
//  });
//
//  print(DotEnv().env['API_ENDPOINT']);
//  Hive.registerAdapter(AuthAdapter());
//  var box = await Hive.openBox('iotpack');
//
//  box.listenable().addListener(() {
//    print("数据更新变化");
//  });
//
//  var auth = Auth()
//    ..name = DotEnv().env['VAR_NAME']
//    ..token = '';
//  box.put("auth", auth);
//  print('XXXXXName: ${box.get('auth').name}');

//  AMapLocationClient.setApiKey("e2343505c0a2498c098c2fdaecdf7a25");
  runApp(IotPack());
}

class IotPack extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        theme: ThemeData(
            primaryColor: Colors.black,
            tabBarTheme: TabBarTheme(labelStyle: TextStyle())),
        routes: routes,
        home: homePage());
  }
}
