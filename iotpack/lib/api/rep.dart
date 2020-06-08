import 'package:iotpack/dto/loginDto.dart';

class Resp<T> {
  int code;
  String msg;
  T data;

  Resp(this.code, this.msg, this.data);

  Resp.fromJson(Map<String, dynamic> json) {
    code = json['code'];
    msg = json['msg'];
    if (T is LoginDto) {
      data = LoginDto.fromJson(json['data']) as T;
    }
  }
}
