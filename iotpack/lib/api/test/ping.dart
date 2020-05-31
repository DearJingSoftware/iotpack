import '../request.dart';

Future fetchPing() {
  var s = "ss";
  return IotPackApi().get("ping", s);
}
