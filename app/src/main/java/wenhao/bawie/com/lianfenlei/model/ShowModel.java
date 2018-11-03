package wenhao.bawie.com.lianfenlei.model;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by HP on 2018/10/24.
 */

public class ShowModel {
    private OkHttpClient okHttpClient = new OkHttpClient();

    public void show(final ShowCallback showCallback){
        Request request = new Request.Builder()
                .url("http://www.zhaoapi.cn/product/getCatagory")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                showCallback.failure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                showCallback.success(call,response);
            }
        });
    }

    public interface ShowCallback {
        void failure(Call call, IOException e);

        void success(Call call, Response response);
    }
}
