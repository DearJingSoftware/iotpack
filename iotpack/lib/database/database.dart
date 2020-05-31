import 'dart:async';

import 'package:floor/floor.dart';
import 'package:iotpack/dao/deviceDao.dart';
import 'package:iotpack/entitys/device.dart';
import 'package:sqflite/sqflite.dart' as sqflite;

part 'database.g.dart';

@Database(version: 1, entities: [Device])
abstract class AppDatabase extends FloorDatabase {
  DeviceDao get deviceDao;
}
