package bwie.com.liyongtao20130102.network;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttp {
    private static final String TAG="OkHttp";
    private static OkHttpClient okHttpClient;
    private static Request request;
        //okhttpget请求
    public static  void OkHttpGet(String url, final getData data){
        okHttpClient = new OkHttpClient();
        request = new Request.Builder().url(url).method("GET",null).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                data.getData(response.body().string());
            }
        });
    }
    public interface getData{
        void getData(String data);
    }
    public interface getPostData{
        void getLogin(String login);
    }
}
