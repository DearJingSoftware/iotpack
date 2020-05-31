import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:hive/hive.dart';
import 'package:hive_flutter/hive_flutter.dart';
import 'package:iotpack/pages/home.dart';
import 'package:iotpack/route.dart';
import 'package:iotpack/stores/auth.dart';
import 'package:path_provider/path_provider.dart';

import 'api/test/ping.dart';
import 'database/database.dart';

void main() async {
  //设置高德地图ioskey
  print("启动应用");

  if (!kIsWeb) {
    Hive.initFlutter();
    var dir = await getApplicationDocumentsDirectory();
    Hive.init(dir.path);
  }

  final database =
      await $FloorAppDatabase.databaseBuilder('app_database.db').build();
  final deviceDao = database.deviceDao;

//  final device = Device(1, 'Frank');
//  await deviceDao.insertDevice(device);

  final result = await deviceDao.findDeviceById(1);
  result.first.then((value) => {print(value.name)});

  print("加载配置文件");
  await DotEnv().load('.env').catchError((e) {
    print("加载配置文件出错");
    print(e.toString());
  });

  print(DotEnv().env['API_ENDPOINT']);
  Hive.registerAdapter(AuthAdapter());
  var box = await Hive.openBox('iotpack');

  box.listenable().addListener(() {
    print("数据更新变化");
  });

  fetchPing().then((value) {
    print("网络获取数据成功");
    print(value.body.toString());
  });

  var auth = Auth()
    ..name = DotEnv().env['VAR_NAME']
    ..token = '111';
  box.put("auth", auth);
  print('XXXXXName: ${box.get('auth').name}');

//  AMapLocationClient.setApiKey("e2343505c0a2498c098c2fdaecdf7a25");
  runApp(IotPack());
}

class IotPack extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        theme: ThemeData(
//            primaryColor: Colors.black,
//            tabBarTheme: TabBarTheme(labelStyle: TextStyle())
            ),
        routes: routes,
        home: homePage());
  }
}
