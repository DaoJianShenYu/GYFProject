package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;

import com.hrw.memoryleak.R;

/**
 * Created by 高烨峰 on 2016/12/26.
 */
public class BottomSheetActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_activity);
    }
}
