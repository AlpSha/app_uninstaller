import 'dart:async';
import 'package:flutter/services.dart';

class UninstallApps {
  static const MethodChannel _channel = const MethodChannel('uninstall_apps');



  static Future uninstall(String app) async {
        
       _channel.invokeMethod('Uninstall',{"App":app});

  }
}


