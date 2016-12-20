package com.hrw.network.volleytwiceencap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hrw.network.R;
import com.hrw.network.volleytwiceencap.http.IResponse;
import com.hrw.network.volleytwiceencap.http.httputils.UHU;

/**
 * Created by 高烨峰 on 2016/12/16.
 */
public class VolleyTwiceEncap extends Activity implements View.OnClickListener {
    private Button bt_volley_twice_encap_req_net;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_twice_encap);
        initView();
    }

    private void initView() {
        bt_volley_twice_encap_req_net = (Button) findViewById(R.id.bt_volley_twice_encap_req_net);

        bt_volley_twice_encap_req_net.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_volley_twice_encap_req_net:
                new UHU(){

                    @Override
                    public void onGetResponseSuccess(int requestCode, IResponse response) {

                    }
                };
                break;
        }
    }
}
