package cn.yj.store.utils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 网络请求
 */
public class OkRequest {
    private final String TAG = "OkRequest.class";
    //    private final String PATH = "https://spain.coloseo.cn/api/";
    private OkHttpClient okHttpClient = new OkHttpClient();
    private final String PATH = "http://guolin.tech/api/";


    public Response sendGet(String url) {
        Response response = null;
        Request request = new Request.Builder()
                .url(PATH + url)
                .build();
        try {
            response = okHttpClient.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    public void sendPost(String path, Object body) {
    }

    public Response sendDelete(String path) {

        return null;
    }

    public void sendPut(String path, Object body) {
    }
}
