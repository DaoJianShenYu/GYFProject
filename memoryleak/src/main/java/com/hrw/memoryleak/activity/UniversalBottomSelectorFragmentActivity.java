package com.hrw.memoryleak.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.fragment.MyFragment0;
import com.hrw.memoryleak.fragment.MyFragment1;
import com.hrw.memoryleak.fragment.MyFragment2;
import com.hrw.memoryleak.fragment.MyFragment3;
import com.hrw.memoryleak.global.MyApplication;
import com.hrw.memoryleak.utils.ToastUtils;

import java.util.ArrayList;

/**
 * Created by 高烨峰 on 2016/12/21.
 */
public class UniversalBottomSelectorFragmentActivity extends FragmentActivity implements View.OnClickListener {
    private FrameLayout fl_fragment_container;
    private LinearLayout ll_bottom_switcher_container;
    private int bottomSwitcherChildCount;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal_radio_fragment_activity);
        initView();

        bottomSwitcherChildCount = ll_bottom_switcher_container.getChildCount();
        for (int i = 0; i < bottomSwitcherChildCount; i++) {
            View childAt = ll_bottom_switcher_container.getChildAt(i);
            childAt.setOnClickListener(this);
        }
        supportFragmentManager = getSupportFragmentManager();
        fragments.add(new MyFragment0());
        fragments.add(new MyFragment1());
        fragments.add(new MyFragment2());
        fragments.add(new MyFragment3());
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        for (Fragment fragment : fragments) {
            fragmentTransaction.add(R.id.fl_fragment_container,fragment);
        }
        fragmentTransaction.commit();
        swichFragment(0);
        updateBottomSwitcherUI(0);
    }

    private void initView() {
        fl_fragment_container = (FrameLayout) findViewById(R.id.fl_fragment_container);
        ll_bottom_switcher_container = (LinearLayout) findViewById(R.id.ll_bottom_switcher_container);
    }

    @Override
    public void onClick(View v) {
        int index = ll_bottom_switcher_container.indexOfChild(v);
        updateBottomSwitcherUI(index);
        swichFragment(index);
        ToastUtils.showSingleToast(MyApplication.context, "" + index);
    }

    private void updateBottomSwitcherUI(int index) {
        for (int i = 0; i < bottomSwitcherChildCount; i++) {
            View view = ll_bottom_switcher_container.getChildAt(i);
            boolean enable = i != index;
            setViewEnable(view, enable);
        }
    }

    private void setViewEnable(View view, boolean enable) {
        view.setEnabled(enable);
        if (view instanceof ViewGroup) {
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childView = ((ViewGroup) view).getChildAt(i);
                setViewEnable(childView, enable);
            }
        }
    }

    private void swichFragment(int index) {
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        int size = fragments.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = fragments.get(i);
            if (i == index) {
                fragmentTransaction.show(fragment);
            } else {
                fragmentTransaction.hide(fragment);
            }
        }
        fragmentTransaction.commit();
    }
}
