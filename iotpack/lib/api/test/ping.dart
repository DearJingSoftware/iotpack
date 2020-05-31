import 'package:http/http.dart' as http;

Future<http.Response> fetchPing() {
  print("获取数据");
  return http.get('https://jsonplaceholder.typicode.com/albums/1');
}
