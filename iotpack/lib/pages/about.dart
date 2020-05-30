import 'package:flutter/material.dart';

class aboutPage extends StatefulWidget {
  @override
  State<aboutPage> createState() {
    return _HomeState();
  }
}

class _HomeState extends State<aboutPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("关于我们的页面")),
      floatingActionButton: FloatingActionButton(onPressed: () {
        Navigator.pop(context);
      }),
    );
  }
}
