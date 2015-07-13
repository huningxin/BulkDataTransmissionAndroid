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

    private void handleMessage0(int instanceId, int size) {
        byte[] buffer = new byte[size + 1];
        for (int i = 0; i < size; ++i)
            buffer[i] = 'p';
        buffer[size] = 0;
        byte[] encodedBufer = Base64.encodeBase64(buffer);
        String result = new String(encodedBufer);
        postMessage(instanceId, result);
    }

    private void handleMessage1(int instanceId, int size) {
        byte[] buffer = new byte[size + 1];
        for (int i = 0; i < size; ++i)
            buffer[i] = 'p';
        postBinaryMessage(instanceId, buffer);
    }

    @Override
    public void onMessage(int instanceId, String message) {
        String[] parts = message.split(":");
        int messageInterface = Integer.parseInt(parts[0]);
        int size = Integer.parseInt(parts[1]);
        if (messageInterface == 0)
            handleMessage0(instanceId, size);
        else
            handleMessage1(instanceId, size);        
    }

    @Override
    public String onSyncMessage(int instanceId, String message) {
        return message;
    }
}
