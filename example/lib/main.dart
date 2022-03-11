import 'package:flutter/material.dart';
import 'dart:async';
import 'package:uninstall_apps/uninstall_apps.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    await UninstallApps.uninstall("com.instagram.android");
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: TextButton(
            child: Text("Uninstall"),
            onPressed: () {
              initPlatformState();
            },
          ),
        ),
      ),
    );
  }
}
