package com.example.nutritional.util;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author 69182
 */
public class HttpUtils {
    static OkHttpClient client=new OkHttpClient();
    public static <T>T okHttpPost(String urlAddress,FormBody body,Class<T> tClass) throws IOException {
        Request request=new Request.Builder()
                .url(urlAddress)
                .post(body)
                .build();
        String Console=client.newCall(request).execute().body().string();
        Log.d("TAG", "okHttp3: "+Console);
        return new Gson().fromJson(Console,tClass);
    }

    public static <T>T okHttpPost1(String urlAddress, RequestBody body, Class<T> tClass) throws IOException {
        Request request=new Request.Builder()
                .url(urlAddress)
                .post(body)
                .build();
        String Console=client.newCall(request).execute().body().string();
        Log.d("TAG", "okHttp3: "+Console);
        return new Gson().fromJson(Console,tClass);
    }
    public static <T>T okHttpGet(String urlAddress,Class<T> tClass) throws IOException {
        Request request=new Request.Builder()
                .url(urlAddress)
                .get()
                .build();
        String Console=client.newCall(request).execute().body().string();
        Log.d("TAG", "okHttp3: "+Console);
        return new Gson().fromJson(Console,tClass);
    }
}
