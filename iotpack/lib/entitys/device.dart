import 'package:floor/floor.dart';

@entity
class Device {
  @primaryKey
  final int id;

  final String name;

  Device(this.id, this.name);
}
