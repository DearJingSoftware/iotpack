// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'setting.dart';

// **************************************************************************
// TypeAdapterGenerator
// **************************************************************************

class SettingAdapter extends TypeAdapter<Setting> {
  @override
  final typeId = 0;

  @override
  Setting read(BinaryReader reader) {
    var numOfFields = reader.readByte();
    var fields = <int, dynamic>{
      for (var i = 0; i < numOfFields; i++) reader.readByte(): reader.read(),
    };
    return Setting()..API_ENDPOINT = fields[0] as String;
  }

  @override
  void write(BinaryWriter writer, Setting obj) {
    writer
      ..writeByte(1)
      ..writeByte(0)
      ..write(obj.API_ENDPOINT);
  }
}
