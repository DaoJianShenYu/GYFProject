package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hrw.memoryleak.R;

/**
 * Created by 高烨峰 on 2016/12/26.
 */
public class SpannableStringActivity extends Activity implements View.OnClickListener {
    private TextView tv_spannable_string_show;
    private Button bt_spannable_string_price;
    private EditText et_spannable_string_price;
    private String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spannable_string_activity);
        initView();
    }

    private void initView() {
        tv_spannable_string_show = (TextView) findViewById(R.id.tv_spannable_string_show);
        bt_spannable_string_price = (Button) findViewById(R.id.bt_spannable_string_price);
        bt_spannable_string_price.setOnClickListener(this);
        et_spannable_string_price = (EditText) findViewById(R.id.et_spannable_string_price);
        et_spannable_string_price.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_spannable_string_price:
                // validate
                price = et_spannable_string_price.getText().toString().trim();
                if (TextUtils.isEmpty(price)) {
                    Toast.makeText(this, "请输入要显示的价格", Toast.LENGTH_SHORT).show();
                    return;
                }
                SpannableString spannableString = new SpannableString(price);
                if (price.contains(".")) {
                    int index = price.indexOf(".");
                    spannableString.setSpan(new AbsoluteSizeSpan(35), 0, index, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    spannableString.setSpan(new AbsoluteSizeSpan(15), index, price.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    tv_spannable_string_show.setText(spannableString);
                } else {
                    tv_spannable_string_show.setText(price);
                }
                break;
        }
    }
}
