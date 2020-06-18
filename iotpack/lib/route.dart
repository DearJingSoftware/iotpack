import 'package:flutter/material.dart';
import 'package:iotpack/pages/found.dart';
import 'package:iotpack/pages/home.dart';
import 'package:iotpack/pages/login.dart';
import 'package:iotpack/pages/qrcode.dart';
import 'package:iotpack/pages/reg.dart';
import 'package:iotpack/pages/setting.dart';
import 'package:iotpack/pages/user.dart';

import 'pages/about.dart';

var routes = {
  'home': (BuildContext context) => homePage(),
  'login': (BuildContext context) => loginPage(),
  'reg': (BuildContext context) => regPage(),
  'found': (BuildContext context) => foundPage(),
  'about': (BuildContext context) => aboutPage(),
  'setting': (BuildContext context) => settingPage(),
  'user': (BuildContext context) => userPage(),
  'deviceScan': (BuildContext context) => QrcodeScan(),
};
