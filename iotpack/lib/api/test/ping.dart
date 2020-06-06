import 'package:flutter/widgets.dart';

import '../request.dart';

Future fetchPing(BuildContext context) {
  var s = "ss";
  return IotPackApi(context).get("ping");
}
