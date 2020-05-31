import 'package:flutter/material.dart';
import 'package:hive/hive.dart';
import 'package:hive_flutter/hive_flutter.dart';
import 'package:iotpack/stores/auth.dart';

class aboutPage extends StatefulWidget {
  @override
  State<aboutPage> createState() {
    return _HomeState();
  }
}

class _HomeState extends State<aboutPage> {
  @override
  Widget build(BuildContext context) {
    return ValueListenableBuilder(
      valueListenable: Hive.box('iotpack').listenable(),
      builder: (context, box, widget) {
        return Scaffold(
          appBar: AppBar(title: Text(box.get("auth").name)),
          floatingActionButton: FloatingActionButton(
            onPressed: () {
              print("auth xxx");
              Auth auth = box.get("auth");
              auth.name = "xxx";

              box.put("auth", auth);
            },
          ),
        );
      },
    );
  }
}
