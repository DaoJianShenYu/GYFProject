package com.hrw.network;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hrw.network.volleytwiceencap.VolleyTwiceEncap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_main_volley_encap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        bt_main_volley_encap = (Button) findViewById(R.id.bt_main_volley_encap);

        bt_main_volley_encap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_main_volley_encap:
                Intent intent = new Intent(this,VolleyTwiceEncap.class);
                break;
        }
    }
}
