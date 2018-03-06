package com.example.cz.chenzhe20180306.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cz.chenzhe20180306.R;
import com.example.cz.chenzhe20180306.view.GramophoneView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final GramophoneView gramophoneView = (GramophoneView)findViewById(R.id.gramophone_view);
        final Button button = (Button)findViewById(R.id.btn_play_pause);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gramophoneView.getPlaying()){
                    button.setText("点击播放");
                }else{
                    button.setText("点击暂停");
                }
                gramophoneView.setPlaying(!gramophoneView.getPlaying());
            }
        });
    }
}
