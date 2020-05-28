import 'package:flutter/material.dart';
import 'package:amap_location/amap_location.dart';
void main() {
  //设置高德地图ioskey
  AMapLocationClient.setApiKey("e2343505c0a2498c098c2fdaecdf7a25");
  runApp(
      IotPack()
      );
}

class IotPack extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body:DefaultTabController(
          length: choices.length,
          child: Scaffold(
            appBar: AppBar(
              title:Row(children: <Widget>[
                Text("仪表盘"),
              ],),
              bottom: TabBar(
                isScrollable: true,
                tabs: choices.map((Choice choice) {
                  return Tab(
                    text: choice.title,
                    icon: Icon(choice.icon),
                  );
                }).toList(),
              ),
            ),
            body: TabBarView(
              children: choices.map((Choice choice) {
                return Padding(
                  padding: const EdgeInsets.all(0),
                  child: ChoiceCard(choice: choice),
                );
              }).toList(),
            ),
          ),
        ),
          floatingActionButton: FloatingActionButton(
            onPressed: () {
              // Add your onPressed code here!
            },
            child: Icon(Icons.navigation),
            backgroundColor: Colors.blue,
          ),
        floatingActionButtonLocation: FloatingActionButtonLocation.endFloat,
        bottomNavigationBar: BottomNavigationBar(
          currentIndex: 0, // this will be set when a new tab is tapped
          items: [
            BottomNavigationBarItem(
              icon: new Icon(Icons.home),
              title: new Text('仪表盘'),
            ),

            BottomNavigationBarItem(
              icon: new Icon(Icons.mail),
              title: new Text('Messages'),
            ),
            BottomNavigationBarItem(
                icon: Icon(Icons.person),
                title: Text('Profile')
            )
          ],
        ),
      )
    );
  }
}

class Choice {
  const Choice({this.title, this.icon});

  final String title;
  final IconData icon;
}

const List<Choice> choices = const <Choice>[
  const Choice(title: '全部设备', icon: Icons.apps),
  const Choice(title: '烟感', icon: Icons.directions_car),
  const Choice(title: '燃气', icon: Icons.directions_bike),
  const Choice(title: '温度', icon: Icons.directions_boat),
  const Choice(title: '湿度', icon: Icons.directions_bus),
  const Choice(title: '手报', icon: Icons.directions_railway),
  const Choice(title: '门磁', icon: Icons.directions_walk),
  const Choice(title: '传感器', icon: Icons.directions_railway),
  const Choice(title: '传感器', icon: Icons.directions_walk),
  const Choice(title: '传感器', icon: Icons.directions_railway),
  const Choice(title: '传感器', icon: Icons.directions_walk),
];

class ChoiceCard extends StatelessWidget {
  const ChoiceCard({Key key, this.choice}) : super(key: key);

  final Choice choice;

  @override
  Widget build(BuildContext context) {
    final TextStyle textStyle = Theme.of(context).textTheme.body1;
    return Card(
      color: Colors.white,
      child: ListView(
        padding: const EdgeInsets.all(8),
        children: <Widget>[
          Card(
            child: InkWell(
              splashColor: Colors.blue.withAlpha(30),
              onTap: () {
                print('Card tapped.');
              },
              child: Container(
                width: 00,
                height: 100,
                child: Text('Device#'),
              ),
            ),
          ),
          Card(
            child: InkWell(
              splashColor: Colors.blue.withAlpha(30),
              onTap: () {
                print('Card tapped.');
              },
              child: Container(
                width: 300,
                height: 100,
                child: Text('Device#'),
              ),
            ),
          ),
          Card(
            child: InkWell(
              splashColor: Colors.blue.withAlpha(30),
              onTap: () {
                print('Card tapped.');
              },
              child: Container(
                width: 300,
                height: 100,
                child: Text('Device#'),
              ),
            ),
          ),
          Card(
            child: InkWell(
              splashColor: Colors.blue.withAlpha(30),
              onTap: () {
                print('Card tapped.');
              },
              child: Container(
                width: 300,
                height: 100,
                child: Text('Device#'),
              ),
            ),
          ),
          Card(
            child: InkWell(
              splashColor: Colors.blue.withAlpha(30),
              onTap: () {
                print('Card tapped.');
              },
              child: Container(
                width: 300,
                height: 100,
                child: Text('Device#'),
              ),
            ),
          ),
          Card(
            child: InkWell(
              splashColor: Colors.blue.withAlpha(30),
              onTap: () {
                print('Card tapped.');
              },
              child: Container(
                width: 300,
                height: 100,
                child: Text('Device#'),
              ),
            ),
          ),
          Card(
            child: InkWell(
              splashColor: Colors.blue.withAlpha(30),
              onTap: () {
                print('Card tapped.');
              },
              child: Container(
                width: 300,
                height: 100,
                child: Text('Device#'),
              ),
            ),
          ),
          Card(
            child: InkWell(
              splashColor: Colors.blue.withAlpha(30),
              onTap: () {
                print('Card tapped.');
              },
              child: Container(
                width: 300,
                height: 100,
                child: Text('Device#'),
              ),
            ),
          ),
        ],
      )
    );
  }
}
