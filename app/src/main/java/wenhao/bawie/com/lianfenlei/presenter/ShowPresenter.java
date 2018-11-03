package wenhao.bawie.com.lianfenlei.presenter;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;
import wenhao.bawie.com.lianfenlei.model.ShowModel;
import wenhao.bawie.com.lianfenlei.view.ShowView;

/**
 * Created by HP on 2018/10/24.
 */

public class ShowPresenter {
    private ShowModel showModel;
    private ShowView showView;

    public ShowPresenter(ShowView showView) {
        this.showView = showView;
        showModel = new ShowModel();
    }

    public void show(){
        showModel.show(new ShowModel.ShowCallback() {
            @Override
            public void failure(Call call, IOException e) {
                showView.failure("失败");
            }

            @Override
            public void success(Call call, Response response) {
                try {
                    String string = response.body().string();
                    showView.success(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
