package wenhao.bawie.com.lianfenlei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import wenhao.bawie.com.lianfenlei.adapter.FristAdapter;
import wenhao.bawie.com.lianfenlei.bean.FirstBean;
import wenhao.bawie.com.lianfenlei.presenter.ShowPresenter;
import wenhao.bawie.com.lianfenlei.view.ShowView;

public class MainActivity extends AppCompatActivity implements ShowView{

    private RecyclerView first_recyclerView;
    private FirstBean firstBean;
    private List<FirstBean.DataBean> data;
    private FristAdapter fristAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        NewsBeanUtils.getmNewsBeanUtils().init(this);
        first_recyclerView = (RecyclerView) findViewById(R.id.first_recyclerView);

        first_recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        ShowPresenter showPresenter = new ShowPresenter(this);

        if (NetworkUtils.isConnected(this)){
            showPresenter.show();
        }else {
            List<NewsBean> newsBeen = NewsBeanUtils.getmNewsBeanUtils().queryAll();
            String msg = newsBeen.get(0).getMsg();
            Gson gson = new Gson();
            firstBean = gson.fromJson(msg, FirstBean.class);
            data = firstBean.getData();
            fristAdapter = new FristAdapter(MainActivity.this, data);
            first_recyclerView.setAdapter(fristAdapter);
        }
    }

    @Override
    public void failure(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void success(final String msg) {
        NewsBean newsBean = new NewsBean();
        newsBean.setMsg(msg);
        NewsBeanUtils.getmNewsBeanUtils().deleteAll();
        NewsBeanUtils.getmNewsBeanUtils().insert(newsBean);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                firstBean = gson.fromJson(msg, FirstBean.class);
                data = firstBean.getData();
                fristAdapter = new FristAdapter(MainActivity.this, data);
                first_recyclerView.setAdapter(fristAdapter);
            }
        });
    }
}
