package com.devash.uninstall_apps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

public class UninstallAppsPlugin implements FlutterPlugin, ActivityAware, MethodCallHandler {

    private MethodChannel channel;
    private Activity activity;

    @Override
    public void onAttachedToEngine(FlutterPluginBinding binding) {
        channel = new MethodChannel(binding.getBinaryMessenger(), "uninstall_apps");
        channel.setMethodCallHandler(this);
    }

    @Override
    public void onDetachedFromEngine(FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
        channel = null;
    }

    @Override
    public void onDetachedFromActivity() {
        activity = null;
    }

    @Override
    public void onMethodCall(MethodCall call, Result result) {
        if (call.method.equals("Uninstall")) {
            String app = call.argument("App");

            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:" + app));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            activity.startActivity(intent);
        } else {
            result.notImplemented();
        }
    }
}
