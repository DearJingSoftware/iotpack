import 'package:flutter/widgets.dart';
import 'package:iotpack/utils/md5.dart';

import '../request.dart';

Future<T> login<T>(BuildContext context, String username, String password) {
  print(username);
  print(password);
  return IotPackApi(context).post<T>(
      "/auth/login", {"username": username, "password": generateMd5(password)});
}
