import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:http/http.dart' as http;
import 'package:iotpack/api/rep.dart';

class IotPackApi {
  var client = http.Client();
  var context;
  Map<String, String> header = {"Content-type": "application/json"};
  IotPackApi(BuildContext context) {
    this.context = context;

//    header['user-agent'] = "iotpack";
//    header['Content-type'] = "application/json";
  }

  Future<T> post<T>(String path, data) {
    return responseInception<T>(
      requestInception<T>(client, "post", path, data).post(
          DotEnv().env['API_ENDPOINT'] + path,
          body: json.encode(data),
          headers: header),
    );
  }

  Future<T> get<T>(String path) {
    return responseInception(requestInception(client, "get", path, "")
        .get(DotEnv().env['API_ENDPOINT'] + path, headers: header));
  }

  http.Client requestInception<T>(req, String method, String path, data) {
    return req;
  }

  Future<T> responseInception<T>(Future<http.Response> res) {
    return res.then((value) {
      print("解析");
      Resp<T> resbody = Resp.fromJson(json.decode(value.body));
      print("请求结果");
      print(resbody.data);
      if (resbody.code == 0) {
        return resbody.data;
      } else {
        throw (resbody.msg);
      }
    }).catchError((e) {
      print(e.toString());
    });
  }
}
