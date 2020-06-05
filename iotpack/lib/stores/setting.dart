import 'package:hive/hive.dart';

part 'setting.g.dart';

@HiveType(typeId: 0)
class Setting extends HiveObject {
  @HiveField(0)
  String API_ENDPOINT;
}
