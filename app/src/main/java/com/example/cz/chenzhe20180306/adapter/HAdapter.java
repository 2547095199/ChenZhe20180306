package com.example.cz.chenzhe20180306.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cz.chenzhe20180306.R;
import com.example.cz.chenzhe20180306.activity.Main3Activity;
import com.example.cz.chenzhe20180306.bean.ShouBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CZ on 2018/3/6.
 */

public class HAdapter extends RecyclerView.Adapter<HAdapter.MyViewHolder> {
    List<ShouBean.MiaoshaBean.ListBeanX> hlist;
    Context context;

    public HAdapter(List<ShouBean.MiaoshaBean.ListBeanX> hlist, Context context) {
        this.context = context;
        this.hlist = hlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_hadapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String[] split = hlist.get(position).getImages().split("\\|");
        holder.sim.setImageURI(Uri.parse(split[0]));
        holder.price.setText(hlist.get(position).getPrice() + "");
        holder.youhui.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线（删除线）
        holder.youhui.setText(hlist.get(position).getBargainPrice() + "");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Main3Activity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sim)
        SimpleDraweeView sim;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.youhui)
        TextView youhui;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
