import 'package:flutter/material.dart';

class loginPage extends StatefulWidget {
  loginPage({this.title});

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<loginPage> {
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
      padding: EdgeInsets.only(top: 60, left: 20, right: 20),
      child: Column(
        children: <Widget>[
          _buildSetting(context),
          _buildTopLogo(context),
          _buildUsernameField(context),
          SizedBox(
            height: 20,
          ),
          _buildPasswordField(context),
          SizedBox(
            height: 20,
          ),
          _buildSubmitButton(context),
          _buildOtherButton(context)
        ],
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

  Widget _buildUsernameField(BuildContext context) {
    return TextFormField(
        decoration: InputDecoration(
      labelText: '账户',
      filled: true,
      fillColor: Colors.white,
    ));
  }

  Widget _buildPasswordField(BuildContext context) {
    return TextFormField(
      obscureText: true,
      decoration: InputDecoration(
        labelText: '密码',
        filled: true,
        fillColor: Colors.white,
      ),
    );
  }

  Widget _buildSubmitButton(BuildContext context) {
    return ButtonTheme(
      minWidth: double.infinity,
      child: RaisedButton(
        child: Text(
          "登录",
          style: TextStyle(color: Colors.white),
        ),
        onPressed: () {},
      ),
    );
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
