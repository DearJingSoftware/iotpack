import 'package:flutter/material.dart';

class login extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
            appBar: AppBar(
              title: Text('登录页面'),
            ),
            body: Center(
              child: Text('登录'),
            )));
  }
}
