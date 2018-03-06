package com.example.cz.chenzhe20180306;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cz.chenzhe20180306.activity.Main2Activity;
import com.example.cz.chenzhe20180306.adapter.GAdapter;
import com.example.cz.chenzhe20180306.adapter.HAdapter;
import com.example.cz.chenzhe20180306.bean.ShouBean;
import com.example.cz.chenzhe20180306.persenter.ShouPersenter;
import com.example.cz.chenzhe20180306.view.CustomView;
import com.example.cz.chenzhe20180306.view.ShouView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ShouView {

    ShouPersenter persenter = new ShouPersenter(this);
    @BindView(R.id.mybanner)
    CustomView mybanner;
    @BindView(R.id.tv_hour)
    TextView tvHour;
    @BindView(R.id.tv_minute)
    TextView tvMinute;
    @BindView(R.id.tv_second)
    TextView tvSecond;
    @BindView(R.id.recycler_01)
    RecyclerView recycler01;
    @BindView(R.id.recycler_02)
    RecyclerView recycler02;
    static long mHour = 02;
    static long mMin = 15;
    boolean isRun = true;
    static long mSecond = 36;
    Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                //调用 倒计时计算的方法
                computeTime();
                if (mHour < 10) {
                    tvHour.setText("0" + mHour + "");
                } else {
                    tvHour.setText(mHour + "");
                }
                if (mMin < 10) {
                    tvMinute.setText("0" + mMin + "");
                } else {
                    tvMinute.setText(mMin + "");
                }
                if (mSecond < 10) {
                    tvSecond.setText("0" + mSecond + "");
                } else {
                    tvSecond.setText(mSecond + "");
                }
            }
        }
    };
    List<String> list = new ArrayList<>();
    List<ShouBean.MiaoshaBean.ListBeanX> hlist = new ArrayList<ShouBean.MiaoshaBean.ListBeanX>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        persenter.getData();
        startRun();

    }

    @Override
    public void success(ShouBean bean) {
        for (int i = 0; i < bean.getData().size(); i++) {
            list.add(bean.getData().get(i).getIcon());
//            listurl.add(bean.getData().get(i).getUrl());
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mybanner.setData(list/*, listurl*/);
            }
        });

        //recyclerview横滑
        for (int i = 0; i < bean.getMiaosha().getList().size(); i++) {
            hlist.add(bean.getMiaosha().getList().get(i));
        }
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recycler01.setLayoutManager(manager);
        HAdapter hadapter = new HAdapter(hlist, MainActivity.this);
        recycler01.setAdapter(hadapter);
        //recyclerview双行
        GridLayoutManager manager1 = new GridLayoutManager(this, 2);
        recycler02.setLayoutManager(manager1);
        GAdapter gAdapter = new GAdapter(hlist, this);
        recycler02.setAdapter(gAdapter);
    }

    @Override
    public void failuer(String e) {
        Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_SHORT).show();
    }

    /**
     * 开启倒计时
     */
    private void startRun() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRun) {
                    try {
                        //睡眠一秒发送消息handler
                        Thread.sleep(1000);
                        Message message = Message.obtain();
                        message.what = 1;
                        //发送消息
                        timeHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
//调用 倒计时计算的方法

    /**
     * 倒计时计算
     */
    private static void computeTime() {
        //首先把秒减1
        mSecond--;
        if (mSecond < 0) {//如果秒已经减到了0
            mMin--;//分钟就减1
            mSecond = 59;//秒变成 59
            if (mMin < 0) {//如果分钟小于0
                mMin = 59;//分钟变成59
                mHour--;//小时减1
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.shou();
    }
}
