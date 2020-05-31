import 'package:hive/hive.dart';

part 'version.g.dart';

@HiveType(typeId: 0)
class Version extends HiveObject {
  @HiveField(0)
  String version;

  @HiveField(1)
  String name;
}
