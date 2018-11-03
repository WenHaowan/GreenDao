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

public class SenndModel {
    private OkHttpClient okHttpClient = new OkHttpClient();

    public void show(final SenndShowCallback senndShowCallback){
        Request request = new Request.Builder()
                .url("http://www.zhaoapi.cn/product/getProductCatagory")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                senndShowCallback.failure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                senndShowCallback.success(call,response);
            }
        });
    }


    public interface SenndShowCallback {

        void failure(Call call, IOException e);

        void success(Call call, Response response);
    }
}
