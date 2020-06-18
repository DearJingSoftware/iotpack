import 'package:flutter/material.dart';
import 'package:iotpack/api/test/ping.dart';

class homePage extends StatefulWidget {
  @override
  State<homePage> createState() {
    return _HomeState();
  }
}

class Choice {
  const Choice({this.title, this.icon});

  final String title;
  final IconData icon;
}

const List<Choice> choices = const <Choice>[
  const Choice(title: 'All', icon: Icons.border_all),
  const Choice(title: 'CAR', icon: Icons.directions_car),
  const Choice(title: 'BICYCLE', icon: Icons.directions_bike),
  const Choice(title: 'BOAT', icon: Icons.directions_boat),
  const Choice(title: 'BUS', icon: Icons.directions_bus),
  const Choice(title: 'TRAIN', icon: Icons.directions_railway),
  const Choice(title: 'WALK', icon: Icons.directions_walk),
];

class ChoiceCard extends StatelessWidget {
  const ChoiceCard({Key key, this.choice}) : super(key: key);

  final Choice choice;

  @override
  Widget build(BuildContext context) {
    return Center(
        child: GridView(
            gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount: 2, //横轴三个子widget
                childAspectRatio: 1.0 //宽高比为1时，子widget
                ),
            children: <Widget>[
          Icon(Icons.ac_unit),
          Icon(Icons.airport_shuttle),
          Icon(Icons.all_inclusive),
          Icon(Icons.beach_access),
          Icon(Icons.cake),
          Icon(Icons.free_breakfast),
          Icon(Icons.cake),
          Icon(Icons.free_breakfast),
          Icon(Icons.beach_access),
          Icon(Icons.cake),
          Icon(Icons.free_breakfast),
          Icon(Icons.cake),
          Icon(Icons.free_breakfast),
        ]));
  }
}

class _HomeState extends State<homePage> with SingleTickerProviderStateMixin {
  int _currentIndex = 0;
  setIndex(int index) {
    setState(() {
      this._currentIndex = index;
    });
  }

  TabController _tabController;

  @override
  void initState() {
    super.initState();
    _tabController = TabController(vsync: this, length: choices.length);
  }

  @override
  void dispose() {
    _tabController.dispose();
    super.dispose();
  }

  void _nextPage(int delta) {
    final int newIndex = _tabController.index + delta;
    if (newIndex < 0 || newIndex >= _tabController.length) return;
    _tabController.animateTo(newIndex);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("仪表盘"),
          bottom: TabBar(
            controller: _tabController,
            isScrollable: true,
            tabs: choices.map((Choice choice) {
              return Tab(
                text: choice.title,
                icon: Icon(choice.icon),
              );
            }).toList(),
          ),
        ),
        floatingActionButton: FloatingActionButton(
            child: Icon(Icons.add),
            backgroundColor: Colors.black,
            onPressed: () {
              Navigator.of(context).pushNamed("deviceScan");
              fetchPing(context).then((value) {
                showDialog(
                    context: context,
                    builder: (BuildContext context) {
                      return AlertDialog(
                        content: Text(value),
                        title: Center(
                            child: Text(
                          "提示",
                          style: TextStyle(
                              color: Colors.black,
                              fontSize: 20.0,
                              fontWeight: FontWeight.bold),
                        )),
                        actions: <Widget>[
                          FlatButton(
                              onPressed: () {
                                Navigator.of(context).pop();
                              },
                              child: Text('确定')),
                          FlatButton(
                              onPressed: () {
                                Navigator.of(context).pop();
                              },
                              child: Text('取消')),
                        ],
                      );
                    });
                print(value);
              });
            }),
        body: TabBarView(
          controller: _tabController,
          children: choices.map((Choice choice) {
            return ChoiceCard(choice: choice);
          }).toList(),
        ),
        floatingActionButtonLocation: FloatingActionButtonLocation.centerDocked,
        bottomNavigationBar: BottomAppBar(
          color: Colors.white,
          shape: CircularNotchedRectangle(), // 底部导航栏打一个圆形的洞
          child: Row(
            children: [
              IconButton(
                icon: Icon(
                  Icons.dashboard,
                  color: Colors.black,
                ),
                tooltip: "Dashboard",
                onPressed: () {
                  setIndex(0);
                },
              ),
              IconButton(
                tooltip: "DeviceHub",
                icon: Icon(Icons.device_hub),
                onPressed: () {
                  setIndex(1);
                },
              ),
              SizedBox(), //中间位置空出
              IconButton(
                tooltip: "Setting",
                icon: Icon(Icons.settings),
                onPressed: () {
                  setIndex(2);
                },
              ),
              IconButton(
                tooltip: "UserInfo",
                icon: Icon(Icons.perm_identity),
                onPressed: () {
                  Navigator.of(context).pushNamed("login");
                },
              ),
            ],
            mainAxisAlignment: MainAxisAlignment.spaceAround, //均分底部导航栏横向空间
          ),
        ));
  }
}
