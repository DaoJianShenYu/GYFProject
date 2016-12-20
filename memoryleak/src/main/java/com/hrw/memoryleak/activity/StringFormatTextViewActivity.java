package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.hrw.memoryleak.R;

/**
 * Created by 高烨峰 on 2016/12/19.
 */
public class StringFormatTextViewActivity extends Activity {
    private TextView tv_show;
    int num = 3;
    String str = "点";
    double d = 2.2;
    int num2 = 2;

    //String占位符http://blog.csdn.net/lonely_fireworks/article/details/7962171
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        initView();
        String result = "实时更新中,当前大盘指数:<font color='red'>%d</font> %s\n浮点类型:%f" +
                "\n数字缺位数前面补0: %04d";
        result = String.format(result, num,str,d,num2);
        tv_show.setText(result);
    }

    private void initView() {
        tv_show = (TextView) findViewById(R.id.tv_show);
    }
}
