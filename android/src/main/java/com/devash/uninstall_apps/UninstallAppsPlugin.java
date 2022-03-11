package com.devash.uninstall_apps;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

import android.app.Activity;
import android.content.Context;


/** UninstallAppsPlugin */
public class UninstallAppsPlugin implements MethodCallHandler {
   MethodChannel channel;
   Activity activity;




  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "uninstall_apps");
    channel.setMethodCallHandler(new UninstallAppsPlugin(registrar.activity(),channel));
  }

  UninstallAppsPlugin(Activity activity,MethodChannel channel){

    this.activity=activity;
    this.channel=channel;
    this.channel.setMethodCallHandler(this);
      
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
     
     if(call.method.equals("Uninstall")){
     
          String app = call.argument("App");
      
          Intent intent = new Intent(Intent.ACTION_DELETE);
          intent.setData(Uri.parse("package:"+app));
          intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      
           activity.startActivity(intent);
     }
    
    else {
      result.notImplemented();
    }


  }
}
