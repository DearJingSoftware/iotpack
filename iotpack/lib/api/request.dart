import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:hive/hive.dart';
import 'package:http/http.dart' as http;
import 'package:iotpack/stores/auth.dart';

class IotPackApi {
  var client = http.Client();
  var header = new Map();
  var context;
  IotPackApi(BuildContext context) {
    this.context = context;
  }

  Future post(String path, data, receiver) {
    return responseInception(
        requestInception(client, "post", path, data).post(
            DotEnv().env['API_ENDPOINT'] + path,
            body: data,
            headers: header),
        receiver);
  }

  Future get(String path, receiver) {
    return responseInception(
        requestInception(client, "get", path, "")
            .get(DotEnv().env['API_ENDPOINT'] + path),
        receiver);
  }

  http.Client requestInception(req, String method, String path, data) async {
    var box = await Hive.openBox('iotpack');
    Auth auth = box.get("auth");
    if (auth.token == "" || auth.token == null) {
      showDialog(
          context: this.context,
          builder: (BuildContext context) {
            return Dialog(
                insetPadding: EdgeInsets.all(10.0),
                child: Expanded(
                    child: SizedBox(
                  width: 400,
                  height: 300.0,
                  child: Column(
                    children: <Widget>[
                      TextField(
                        decoration: InputDecoration(hintText: 'username'),
                      ),
                      TextField(
                        decoration: InputDecoration(hintText: 'password'),
                      )
                    ],
                  ),
                )));
          });
    }
    return req;
  }

  Future responseInception(Future<http.Response> res, receiver) {
    return res.then((value) {
      Map<String, dynamic> resbody = json.decode(value.body);
      if (resbody["code"] == 0) {
        return resbody['data'];
      } else {
        throw new Exception(resbody['msg']);
      }
    }).catchError((e) {
      print(e.toString());
    });
  }
}
