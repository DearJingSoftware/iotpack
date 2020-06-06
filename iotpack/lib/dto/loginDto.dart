//part 'logindto.g.dart';

class LoginDto {
  String token;

  LoginDto(this.token);

  LoginDto.fromJson(Map<String, dynamic> json) : token = json['token'];
}
