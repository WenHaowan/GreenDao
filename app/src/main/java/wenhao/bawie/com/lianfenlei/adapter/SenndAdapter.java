package wenhao.bawie.com.lianfenlei.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import wenhao.bawie.com.lianfenlei.R;
import wenhao.bawie.com.lianfenlei.bean.SenndBean;

/**
 * Created by HP on 2018/10/24.
 */

public class SenndAdapter extends RecyclerView.Adapter<SenndAdapter.SenndViewHolder>{

    private Context context;
    private List<SenndBean.DataBean.ListBean> list;

    public SenndAdapter(Context context, List<SenndBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public SenndAdapter.SenndViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.sennd_layout, parent, false);
        SenndViewHolder senndViewHolder = new SenndViewHolder(inflate);
        return senndViewHolder;
    }

    @Override
    public void onBindViewHolder(SenndAdapter.SenndViewHolder holder, int position) {
        holder.seed_text.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon()).into(holder.seed_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SenndViewHolder extends RecyclerView.ViewHolder {

        private ImageView seed_image;
        private TextView seed_text;

        public SenndViewHolder(View itemView) {
            super(itemView);

            seed_image = (ImageView) itemView.findViewById(R.id.seed_image);
            seed_text = (TextView) itemView.findViewById(R.id.seed_text);

        }
    }
}
