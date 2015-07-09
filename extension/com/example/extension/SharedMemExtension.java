package com.example.extension;

import org.xwalk.app.runtime.extension.XWalkExtensionClient;
import org.xwalk.app.runtime.extension.XWalkExtensionContextClient;

import android.util.Log;

public class SharedMemExtension extends XWalkExtensionClient {
    private final static String TAG = "SharedMemExtension";
    // Don't change the parameters in Constructor because XWalk needs to call this constructor.
    public SharedMemExtension(String name, String JsApiContent, XWalkExtensionContextClient context) {
        super(name, JsApiContent, context);
    }

    @Override
    public void onStart() {
        Log.e(TAG, "onStart");
    }

    @Override
    public void onStop() {
        Log.e(TAG, "onStop");
    }

    @Override
    public void onMessage(int instanceId, String message) {
        postMessage(instanceId, message);
    }

    @Override
    public String onSyncMessage(int instanceId, String message) {
        return message;
    }
}
