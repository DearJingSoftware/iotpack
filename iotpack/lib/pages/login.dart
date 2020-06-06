import 'package:flutter/material.dart';
import 'package:iotpack/api/test/login.dart';
import 'package:iotpack/dto/loginDto.dart';

class loginPage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<loginPage> {
  String _username = "admin";
  String _password = "admin";

  Widget _buildLayoutContainer(BuildContext context) {
    return SingleChildScrollView(
      child: Form(
        child: Container(
          padding: EdgeInsets.only(top: 60, left: 20, right: 20),
          child: Column(
            children: <Widget>[
              _buildSetting(context),
              _buildTopLogo(context),
              TextFormField(
                  onSaved: (val) {
                    _username = val;
                  },
                  decoration: InputDecoration(
                    labelText: '账户',
                    filled: true,
                    fillColor: Colors.white,
                  )),
              SizedBox(
                height: 20,
              ),
              TextFormField(
                onSaved: (val) {
                  _password = val;
                },
                obscureText: true,
                decoration: InputDecoration(
                  labelText: '密码',
                  filled: true,
                  fillColor: Colors.white,
                ),
              ),
              SizedBox(
                height: 20,
              ),
              ButtonTheme(
                minWidth: double.infinity,
                child: RaisedButton(
                  child: Text(
                    "登录",
                    style: TextStyle(color: Colors.white),
                  ),
                  onPressed: () {
                    print("发起登录请求");
                    login<LoginDto>(context, _username, _password)
                        .then((value) {
                      print(value.token);
                      print("登录返回结果");
                      Navigator.of(context).pushNamed("user");
                    }).catchError((value) {
                      print("登录报错");
                      print(value);
                    });
                  },
                ),
              ),
              _buildOtherButton(context)
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildSetting(BuildContext context) {
    return Padding(
        padding: EdgeInsets.only(bottom: 20),
        child: Align(
            alignment: Alignment.centerRight,
            child: IconButton(
              icon: Icon(Icons.settings),
              onPressed: () {
                Navigator.of(context).pushNamed("setting");
              },
            )));
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

  Widget _buildOtherButton(BuildContext context) {
    return Row(children: [
      RaisedButton(
        onPressed: () => {Navigator.of(context).pushNamed("found")},
        child: Text("找回密码"),
      ),
      Expanded(
          child: Align(
        alignment: Alignment.centerRight,
        child: RaisedButton(
          onPressed: () => {Navigator.of(context).pushNamed("reg")},
          child: Text("注册"),
        ),
      )),
    ]);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: _buildLayoutContainer(context),
    );
  }
}
