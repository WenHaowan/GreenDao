package wenhao.bawie.com.lianfenlei.adapter;

import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.List;

import wenhao.bawie.com.lianfenlei.R;
import wenhao.bawie.com.lianfenlei.bean.FirstBean;
import wenhao.bawie.com.lianfenlei.bean.SenndBean;
import wenhao.bawie.com.lianfenlei.presenter.SenndPresenter;
import wenhao.bawie.com.lianfenlei.view.SenndShowView;

/**
 * Created by HP on 2018/10/24.
 */

public class FristAdapter extends RecyclerView.Adapter<FristAdapter.FristViewHolder> implements SenndShowView{

    private Context context;
    private List<FirstBean.DataBean> list;
    SenndPresenter senndpresenter = new SenndPresenter(this);
    private List<SenndBean.DataBean.ListBean> listBeen;
    private SenndAdapter senndAdapter;

    public FristAdapter(Context context, List<FirstBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public FristAdapter.FristViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.first_layout, parent, false);
        FristViewHolder fristViewHolder = new FristViewHolder(inflate);
        return fristViewHolder;
    }

    @Override
    public void onBindViewHolder(final FristAdapter.FristViewHolder holder, final int position) {
        holder.frist_text.setText(list.get(position).getName());

        holder.seed_recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        holder.frist_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cid = list.get(position).getCid();
                senndpresenter.show1(cid+"");
                holder.seed_recyclerView.setAdapter(senndAdapter);
            }
        });
        /*holder.seed_recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"--------------", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void failure(String msg) {
        Looper.prepare();
        Looper.loop();
    }

    @Override
    public void success(String msg) {
        Looper.prepare();
        Gson gson = new Gson();
        SenndBean senndBean = gson.fromJson(msg, SenndBean.class);
        List<SenndBean.DataBean> data = senndBean.getData();
        for (int i=0;i<data.size();i++){
            listBeen = data.get(i).getList();
            senndAdapter = new SenndAdapter(context, listBeen);
        }
        Looper.loop();
    }

    public class FristViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView seed_recyclerView;
        private TextView frist_text;

        public FristViewHolder(View itemView) {
            super(itemView);

            frist_text = (TextView) itemView.findViewById(R.id.frist_text);
            seed_recyclerView = (RecyclerView) itemView.findViewById(R.id.seed_recyclerView);
        }
    }
}
