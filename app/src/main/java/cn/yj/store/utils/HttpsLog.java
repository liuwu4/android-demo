package cn.yj.store.utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.Response;

public class HttpsLog {
    private String TAG = getClass().getSimpleName();

    public void success(Response response) throws IOException {
        Log.i(TAG, "code: " + response.code());
        Log.i(TAG, "message: " + response.message());
        Log.i(TAG, "body: " + response.body().string());
    }

    public void error(Response response) throws IOException {
        Log.e(TAG, "code: " + response.code());
        Log.e(TAG, "message: " + response.message());
        Log.e(TAG, "body: " + response.body().string());
    }
}
