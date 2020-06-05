import 'package:flutter/material.dart';

class foundPage extends StatefulWidget {
  foundPage({this.title});

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<foundPage> {
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
