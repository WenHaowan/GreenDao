package wenhao.bawie.com.lianfenlei.presenter;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;
import wenhao.bawie.com.lianfenlei.model.SenndModel;
import wenhao.bawie.com.lianfenlei.view.SenndShowView;

/**
 * Created by HP on 2018/10/24.
 */

public class SenndPresenter {
    private SenndModel senndModel;
    private SenndShowView senndShowView;

    public SenndPresenter(SenndShowView senndShowView) {
        this.senndShowView = senndShowView;
        senndModel = new SenndModel();
    }

    public void show1(String cid){
        senndModel.show(new SenndModel.SenndShowCallback() {
            @Override
            public void failure(Call call, IOException e) {
                senndShowView.failure("失败");
            }

            @Override
            public void success(Call call, Response response) {
                try {
                    String string = response.body().string();
                    senndShowView.success(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
