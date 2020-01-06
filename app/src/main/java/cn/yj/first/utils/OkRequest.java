package cn.yj.first.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 网络请求
 */
public class OkRequest {
    private final String TAG = getClass().getSimpleName();
    private final static String developUrl = "https://spain.coloseo.cn/api/";
    //    private final String developUrl = "https://spain-api.coloseo.cn/api/";
    private OkHttpClient okHttpClient = new OkHttpClient();
    public static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    public void sendBaidu(Handler handler) {
        Request request = new Request.Builder()
                .url("http://c.m.163.com/nc/article/headline/T1348647853363/0-40.html")
                .build();
        Message message = new Message();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200) {
                    message.what = response.code();
                    message.obj = response.body().string();
                    handler.sendMessage(message);
                } else {
                    message.what = response.code();
                    message.obj = "{message: \"请求异常\"}";
                    handler.sendMessage(message);
                }
            }
        });
    }

    public Message sendGet(String url, Handler handler) {
        Request request = new Request.Builder()
                .url(developUrl + url)
                .build();
        Message message = new Message();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200) {
                    message.what = response.code();
                    message.obj = response.body().string();
                    handler.sendMessage(message);
                } else {
                    message.what = response.code();
                    message.obj = "{message: \"请求异常\"}";
                    handler.sendMessage(message);
                }
            }
        });
        return message;
    }

    /**
     * @param method  [put, post]
     * @param url     请求url
     * @param json    body 参数
     * @param handler 更新ui
     */
    public void sendMethod(String method, String url, String json, Handler handler) {
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE, json);
        Log.d(TAG, "sendMethod: " + json);
        Request request = new Request.Builder()
                .method(method, requestBody)
                .url(developUrl + url)
                .build();
        Message message = new Message();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: " + developUrl + url);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: " + response);
                if (response.code() == 200) {
                    message.what = response.code();
                    message.obj = response.body().string();
                } else {
                    message.what = response.code();
                    message.obj = "{message: \"数据错误\"" + "}";
                }
                handler.sendMessage(message);
            }
        });
    }
}
