package com.hrw.memoryleak.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hrw.memoryleak.R;

/**
 * Created by 高烨峰 on 2016/12/21.
 */
public class MyFragment2 extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment2, null);
        return view;
    }
}
