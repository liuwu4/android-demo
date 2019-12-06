package cn.yj.store.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 网络请求
 */
public class OkRequest {
    private final String TAG = getClass().getSimpleName();
    private final static String developUrl = "https://spain.coloseo.cn/api/";
//    private final String developUrl = "https://spain-api.coloseo.cn/api/";
//        private final String PATH = "https://spain.coloseo.cn/api/";
    private OkHttpClient okHttpClient = new OkHttpClient();

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
                if (response.code() == 200 ) {
                    message.what = 1;
                    message.obj = response.body().string();
                    handler.sendMessage(message);
                } else {
                    message.what = 1;
                    message.obj = "没有任何有用信息";
                    handler.sendMessage(message);
                }
            }
        });
        return message;
    }
}
