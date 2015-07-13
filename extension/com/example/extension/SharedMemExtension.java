package com.example.extension;

import org.xwalk.app.runtime.extension.XWalkExtensionClient;
import org.xwalk.app.runtime.extension.XWalkExtensionContextClient;

import android.util.Log;

import org.apache.commons.codec.binary.Base64;

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
        int size = Integer.parseInt(message);
        byte[] buffer = new byte[size];
        for (int i = 0; i < size; ++i)
            buffer[i] = 'p';
        String result = new String(buffer);
        postMessage(instanceId, result);
    }

    @Override
    public String onSyncMessage(int instanceId, String message) {
        return message;
    }
}
