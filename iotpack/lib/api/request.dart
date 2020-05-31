import 'dart:convert';

import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:http/http.dart' as http;

class IotPackApi {
  var client = http.Client();
  var header = new Map();
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

  requestInception(req, String method, String path, data) {
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
