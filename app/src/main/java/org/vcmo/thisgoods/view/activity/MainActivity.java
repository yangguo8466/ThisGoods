package org.vcmo.thisgoods.view.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarFragment;
import com.roughike.bottombar.OnMenuTabClickListener;

import org.vcmo.thisgoods.R;
import org.vcmo.thisgoods.view.base.BaseActivity;
import org.vcmo.thisgoods.view.base.BaseFragment;
import org.vcmo.thisgoods.view.fragment.SimpleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jie on 2016-05-11.
 */
public class MainActivity extends BaseActivity {

    private BottomBar mBottomBar;

    private FragmentManager fm = getSupportFragmentManager();
    private FragmentTransaction ft;

    private List<BaseFragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        initBottomBar();

        init();
    }

    private void init() {

        fragments = new ArrayList<>();
        fragments.add(SimpleFragment.newInstance("search fragment"));
        fragments.add(SimpleFragment.newInstance("center fragment"));
        fragments.add(SimpleFragment.newInstance("about fragment"));


        ft = fm.beginTransaction();

        for (BaseFragment bf :
                fragments) {

        }

    }

    private void initBottomBar() {


        mBottomBar.setItemsFromMenu(R.menu.bottom_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

        mBottomBar.setActiveTabColor(ContextCompat.getColor(this, R.color.mainRed));

    }


    private void changeFragmentView(BaseFragment fragment) {

        ft = fm.beginTransaction();

        for (BaseFragment f :
                fragments) {
            if (f == fragment)
                continue;


        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mBottomBar.onSaveInstanceState(outState);

    }
}
