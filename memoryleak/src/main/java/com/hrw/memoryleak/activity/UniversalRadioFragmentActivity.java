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
import android.widget.Toast;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.global.MyApplication;

import java.util.ArrayList;

/**
 * Created by 高烨峰 on 2016/12/21.
 */
public class UniversalRadioFragmentActivity extends FragmentActivity implements View.OnClickListener {
    private FrameLayout fl_fragment_container;
    private LinearLayout ll_bottom_switcher_container;
    private int bottomSwitcherChildCount;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private FragmentManager fragmentManager;

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

        fragments.add(new MyFragment1());
        fragments.add(new MyFragment2());
        fragments.add(new MyFragment3());
        fragments.add(new MyFragment4());
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        int i = 1;
        for (Fragment fragment : fragments) {
            fragmentTransaction.add(R.id.fl_fragment_container, fragment, "fragment" + i);
            if (i > 1) {
                fragmentTransaction.hide(fragment);
            }
            i++;
        }
        fragmentTransaction.commit();
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
        Toast.makeText(MyApplication.context, "" + index, Toast.LENGTH_SHORT).show();
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
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        int size = fragments.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = fragments.get(index);
            if (i == index) {
                fragmentTransaction.show(fragment);
            } else {
                fragmentTransaction.hide(fragment);
            }
        }
        fragmentTransaction.commit();
    }
}
