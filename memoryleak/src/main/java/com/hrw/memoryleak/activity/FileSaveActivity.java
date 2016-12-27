package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.utils.ToastUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 高烨峰 on 2016/12/26.
 */
public class FileSaveActivity extends Activity implements View.OnClickListener {
    private TextView tv_file_save_activity_show;
    private EditText et_file_save_activity_input;
    private Button bt_file_save_activity_write;
    private Button bt_file_save_activity_read;
    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_save_activity);
        initView();

    }

    private void initView() {
        tv_file_save_activity_show = (TextView) findViewById(R.id.tv_file_save_activity_show);
        et_file_save_activity_input = (EditText) findViewById(R.id.et_file_save_activity_input);
        bt_file_save_activity_write = (Button) findViewById(R.id.bt_file_save_activity_write);
        bt_file_save_activity_read = (Button) findViewById(R.id.bt_file_save_activity_read);

        bt_file_save_activity_write.setOnClickListener(this);
        bt_file_save_activity_read.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_file_save_activity_write:
                if (submit()) {
                    try {
                        FileOutputStream fos = this.openFileOutput("info.txt", Context.MODE_PRIVATE);
                        fos.write(input.getBytes());
                        fos.close();
                        ToastUtils.showToast(this, "保存成功");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.bt_file_save_activity_read:
                if (submit()) {
                    try {
                        FileInputStream fis = this.openFileInput("info.txt");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
                        String s = bufferedReader.readLine();
                        bufferedReader.close();
                        tv_file_save_activity_show.setText(s);
                        ToastUtils.showToast(this, "读取成功");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    private boolean submit() {
        //validate
        input = et_file_save_activity_input.getText().toString().trim();
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "请输入文本", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
