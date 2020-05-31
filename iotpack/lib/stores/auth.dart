import 'package:hive/hive.dart';

part 'auth.g.dart';

@HiveType(typeId: 0)
class Auth extends HiveObject {
  @HiveField(0)
  String token;

  @HiveField(1)
  String name;
}
