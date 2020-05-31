import 'package:floor/floor.dart';
import 'package:iotpack/entitys/device.dart';

@dao
abstract class DeviceDao {
  @Query('SELECT * FROM device')
  Future<List<Device>> findAllPersons();

  @Query('SELECT * FROM device WHERE id = :id')
  Stream<Device> findDeviceById(int id);

  @insert
  Future<void> insertDevice(Device device);
}
