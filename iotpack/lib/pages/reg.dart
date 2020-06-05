import 'package:flutter/material.dart';

class regPage extends StatefulWidget {
  regPage({this.title});

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<regPage> {
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
          _buildPhoneField(context),
          SizedBox(
            height: 20,
          ),
          _buildPasswordField(context),
          _buildRePasswordField(context),
          SizedBox(
            height: 20,
          ),
          _buildSubmitButton(context),
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
    return TextFormField(
        decoration: InputDecoration(
      labelText: '账户',
      filled: true,
      fillColor: Colors.white,
    ));
  }

  Widget _buildPhoneField(BuildContext context) {
    return TextFormField(
        decoration: InputDecoration(
      labelText: '手机号',
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

  Widget _buildRePasswordField(BuildContext context) {
    return TextFormField(
      obscureText: true,
      decoration: InputDecoration(
        labelText: '确认密码',
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
          "注册",
          style: TextStyle(color: Colors.white),
        ),
        onPressed: () {},
      ),
    );
  }

  Widget _buildOtherButton(BuildContext context) {
    return Row(children: [
      RaisedButton(
        onPressed: () => {Navigator.of(context).pop()},
        child: Text("返回登陆"),
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
