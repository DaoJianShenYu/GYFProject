package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.hrw.memoryleak.R;

/**
 * Created by 高烨峰 on 2016/12/19.
 */
public class HtmlTextViewActivity extends Activity {
    private TextView tv_show;
    int num = 3112;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        initView();
        String result = "实时更新中(标签换行)<br>，当前(标签粗体)<b>大盘</b>指数：" +
                "(标签颜色可以,大小和字体无效)<font color='red'size='3'face='verdana'>" + num + "</font>" +
                "<br>(标签超链接效果)<a href=\"http://www.cnblogs.com/mxgsa/archive/2012/11/15/2760256.html\">超链接</a>" +
                "<br>(比周围大一号字体)<big>大一号</big>" +
                "<br>(删除线)<strike>删除线</strike>" +
                "<br>(下标)<sub>下标</sub>"+
                "<br>(下标)<tt>s等宽ss字体</tt>";
        tv_show.setText(Html.fromHtml(result));
    }

    private void initView() {
        tv_show = (TextView) findViewById(R.id.tv_show);
    }
}
