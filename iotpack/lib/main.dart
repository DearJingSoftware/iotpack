import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:hive/hive.dart';
import 'package:hive_flutter/hive_flutter.dart';
import 'package:iotpack/pages/home.dart';
import 'package:iotpack/route.dart';
import 'package:path_provider/path_provider.dart';

void main() async {
  //设置高德地图ioskey
  print("启动应用");
  if (!kIsWeb) {
    Hive.initFlutter();
    var dir = await getApplicationDocumentsDirectory();
    Hive.init(dir.path);
  }
  var box = await Hive.openBox('iotpack');
  box.put('name', 'David');
  print('XXXXXName: ${box.get('name')}');

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
