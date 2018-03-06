package com.example.cz.chenzhe20180306.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cz.chenzhe20180306.R;
import com.example.cz.chenzhe20180306.adapter.MyAdapter;
import com.example.cz.chenzhe20180306.bean.GoWuCheBean;
import com.example.cz.chenzhe20180306.persenter.GoWuChePersenter;
import com.example.cz.chenzhe20180306.view.GoWuCheView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity implements GoWuCheView, View.OnClickListener {
    GoWuChePersenter persenter = new GoWuChePersenter(this);
    @BindView(R.id.third_recyclerview)
    RecyclerView thirdRecyclerview;
    @BindView(R.id.third_allselect)
    CheckBox thirdAllselect;
    @BindView(R.id.third_totalprice)
    TextView thirdTotalprice;
    @BindView(R.id.third_totalnum)
    TextView thirdTotalnum;
    @BindView(R.id.third_submit)
    TextView thirdSubmit;
    @BindView(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        persenter.getData("101", "android");

        thirdAllselect.setOnClickListener(this);
        adapter = new MyAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        thirdRecyclerview.setLayoutManager(manager);
        //recyclerview里添加数据
        thirdRecyclerview.setAdapter(adapter);
        Log.e("数据", adapter.toString());
        //适配器的事件
        adapter.setListener(new MyAdapter.UpdateUiListener() {

            @Override
            public void setToal(String total, String num, boolean allcheck) {
                thirdAllselect.setChecked(allcheck);
                thirdTotalnum.setText(num);
                thirdTotalprice.setText(total);
            }
        });

    }

    @Override
    public void success(GoWuCheBean bean) {
        adapter.add(bean);

        Toast.makeText(Main3Activity.this, bean.getData().get(2).getList().get(0).getTitle() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failuer(String e) {
        Toast.makeText(Main3Activity.this, "错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.gowuche();
    }

    @Override
    public void onClick(View view) {
        adapter.selectAll(thirdAllselect.isChecked());

    }
}
