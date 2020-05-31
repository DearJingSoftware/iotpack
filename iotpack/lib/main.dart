import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:hive/hive.dart';
import 'package:hive_flutter/hive_flutter.dart';
import 'package:iotpack/pages/home.dart';
import 'package:iotpack/route.dart';
import 'package:iotpack/stores/auth.dart';
import 'package:path_provider/path_provider.dart';

void main() async {
  //设置高德地图ioskey
  print("启动应用");
  if (!kIsWeb) {
    Hive.initFlutter();
    var dir = await getApplicationDocumentsDirectory();
    Hive.init(dir.path);
  }
  Hive.registerAdapter(AuthAdapter());
  var box = await Hive.openBox('iotpack');

  box.listenable().addListener(() {
    print("数据更新变化");
  });

  var auth = Auth()
    ..name = 'aaa'
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
