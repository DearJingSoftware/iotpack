import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:hive/hive.dart';
import 'package:hive_flutter/hive_flutter.dart';
import 'package:iotpack/stores/setting.dart';
import 'package:path_provider/path_provider.dart';

Future<void> InitHive() async {
  Hive.initFlutter();
  var dir = await getApplicationDocumentsDirectory();
  Hive.init(dir.path);
  Hive.registerAdapter(SettingAdapter());
  var box = await Hive.openBox('setting');
  var default_setting = await Hive.openBox('default_setting');
  await DotEnv().load('.env').then((value) {
//    var setting = Setting();
//    setting.API_ENDPOINT = DotEnv().env['API_ENDPOINT'];
    print("加载env配置文件");
    box.put("API_ENDPOINT", DotEnv().env['API_ENDPOINT']);
    default_setting.put("API_ENDPOINT", DotEnv().env['API_ENDPOINT']);
//    box.put("default_setting", setting);
  }).catchError((e) {
    print("加载配置文件出错");
    print(e.toString());
  });
}
