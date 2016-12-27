package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.global.MyApplication;
import com.hrw.memoryleak.utils.ToastUtils;

/**
 * Created by 高烨峰 on 2016/12/26.
 */
public class CustomDialogActivity extends Activity implements View.OnClickListener {
    private Button bt_custom_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog_activity);
        initView();

    }

    private void initView() {
        bt_custom_dialog = (Button) findViewById(R.id.bt_custom_dialog);

        bt_custom_dialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_custom_dialog:
                final Dialog dialog = new Dialog(this, R.style.MyDialogTheme);
                View dialogView = View.inflate(this, R.layout.custom_dialog_view, null);
                Button confirm = (Button)dialogView.findViewById(R.id.bt_custom_dialog_confirm);
                Button cancel = (Button)dialogView.findViewById(R.id.bt_custom_dialog_cancel);

                dialog.setContentView(dialogView);
                WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
//                attributes.width = 200;
//                attributes.height = 200;
                attributes.x = 100;
                attributes.y = 100;
                //attributes.alpha = 0.5f;
                attributes.gravity = Gravity.CENTER;
                dialog.getWindow().setAttributes(attributes);
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.showToast(MyApplication.context,"确认");
                        dialog.dismiss();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.showToast(MyApplication.context,"取消");
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
        }
    }
}
