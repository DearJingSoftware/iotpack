import 'package:flutter/material.dart';
import 'package:hive/hive.dart';
import 'package:hive_flutter/hive_flutter.dart';

class settingPage extends StatefulWidget {
  settingPage({this.title});

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<settingPage> {
  Widget _buildLayoutContainer(BuildContext context) {
    return SingleChildScrollView(
      child: _buildFormWrapper(context),
    );
  }

  Widget _buildFormWrapper(BuildContext context) {
    return Form(
      child: _buildLoginLayout(context),
    );
  }

  Widget _buildLoginLayout(BuildContext context) {
    return Container(
      padding: EdgeInsets.only(top: 100, left: 20, right: 20),
      child: Column(
        children: <Widget>[
          _buildTopLogo(context),
          _buildUsernameField(context),
          SizedBox(
            height: 20,
          ),
//          _buildSubmitButton(context),
//          _buildSaveButton(context),
//          _buildResetButton(context),
          _buildOtherButton(context)
        ],
      ),
    );
  }

  Widget _buildTopLogo(BuildContext context) {
    print(context);
    return Padding(
        padding: EdgeInsets.only(bottom: 20),
        child: SizedBox(
          child: Image.asset("assets/logo.png"),
          height: 100,
          width: 100,
        ));
  }

  Widget _buildUsernameField(BuildContext context) {
    return ValueListenableBuilder(
      valueListenable: Hive.box('setting').listenable(keys: ['API_ENDPOINT']),
      builder: (context, Box<dynamic> box, widget) {
        print("配置发生变更");
        print(box.get("API_ENDPOINT"));

        return TextFormField(
            onSaved: (v) {
              box.put("API_ENDPOINT", v);
            },
            initialValue: box.get("API_ENDPOINT"),
            decoration: InputDecoration(
              labelText: "API_ENDPOINT",
              filled: true,
              fillColor: Colors.white,
            ));
      },
    );
  }

  Widget _buildSubmitButton(BuildContext context) {
    return ButtonTheme(
      minWidth: double.infinity,
      child: RaisedButton(
        child: Text(
          "确认",
          style: TextStyle(color: Colors.white),
        ),
        onPressed: () {},
      ),
    );
  }

  Widget _buildSaveButton(BuildContext context) {
    return ButtonTheme(
      minWidth: double.infinity,
      child: RaisedButton(
        child: Text(
          "保存",
          style: TextStyle(color: Colors.white),
        ),
        onPressed: () {},
      ),
    );
  }

  Widget _buildResetButton(BuildContext context) {
    return ButtonTheme(
      minWidth: double.infinity,
      child: RaisedButton(
        child: Text(
          "重置",
          style: TextStyle(color: Colors.white),
        ),
        onPressed: () {
          Hive.openBox('setting').then((box) {
            Hive.openBox('default_setting').then((defalut) {
              box.put("API_ENDPOINT", defalut.get("API_ENDPOINT"));
            });
          });
        },
      ),
    );
  }

  Widget _buildOtherButton(BuildContext context) {
    return Row(children: [
      RaisedButton(
        onPressed: () => {Navigator.of(context).pop()},
        child: Text("返回"),
      ),
    ]);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: _buildLayoutContainer(context),
    );
  }
}
