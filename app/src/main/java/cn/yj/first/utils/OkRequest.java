package cn.yj.first.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
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
                Log.w(TAG, "onResponse: " + response.code());
                Log.w(TAG, "onResponse: " + response.body());
                if (response.code() == 200) {
                    message.what = response.code();
                    message.obj = response.body().string();
                    handler.sendMessage(message);
                    new HttpsLog().success(response);
                } else {
                    message.what = response.code();
                    message.obj = "{message: \"请求异常\"}";
                    handler.sendMessage(message);
                    new HttpsLog().error(response);
                }
            }
        });
        return message;
    }

    public void sendMethod(String method, String url, RequestBody body, Handler handler) {
        Request request = new Request.Builder()
                .method(method, body)
                .url(developUrl + url)
                .build();
        Message message = new Message();
       Call call = okHttpClient.newCall(request);
       call.enqueue(new Callback() {
           @Override
           public void onFailure(Call call, IOException e) {
               Log.e(TAG, "onFailure: "+developUrl+url);
           }

           @Override
           public void onResponse(Call call, Response response) throws IOException {
               if(response.code() == 200){
                    message.what = response.code();
                    message.obj = response.body().string();
                    new HttpsLog().success(response);
                } else {
                    message.what = response.code();
                    message.obj = "{message: \"数据错误\""+"}";
                    new HttpsLog().error(response);
                }
                handler.sendMessage(message);
           }
       });
    }
}
