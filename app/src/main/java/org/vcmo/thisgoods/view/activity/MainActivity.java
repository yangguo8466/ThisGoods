package org.vcmo.thisgoods.view.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import org.vcmo.thisgoods.R;
import org.vcmo.thisgoods.view.base.BaseActivity;
import org.vcmo.thisgoods.view.base.BaseFragment;
import org.vcmo.thisgoods.view.fragment.MainFragment;
import org.vcmo.thisgoods.view.fragment.SimpleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jie on 2016-05-11.
 */
public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private BottomBar mBottomBar;

    private FragmentManager fm = getSupportFragmentManager();
    private FragmentTransaction ft;

    private List<BaseFragment> fragments;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        init();

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        initBottomBar();

    }

    private void init() {

        fragments = new ArrayList<>();
        fragments.add(0, MainFragment.newInstance());
        fragments.add(1, SimpleFragment.newInstance("center fragment"));
        fragments.add(2, SimpleFragment.newInstance("about fragment"));

        ft = fm.beginTransaction();
        for (BaseFragment f :
                fragments) {
            ft.add(R.id.main_contain, f);
        }
        ft.commit();

    }

    private void initBottomBar() {


        mBottomBar.setItemsFromMenu(R.menu.bottom_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                int index = 0;
                switch (menuItemId) {
                    case R.id.menu_about:
                        index = 2;
                        break;
                    case R.id.menu_center:
                        index = 1;
                        break;
                }

                Log.d(TAG, "onMenuTabSelected: ------- " + index);

                changeFragmentView(fragments.get(index));
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.menu_search) {
                    MainFragment mainF = (MainFragment) fragments.get(0);
                    mainF.goToTop();
                }
            }
        });

        mBottomBar.setActiveTabColor(ContextCompat.getColor(this, R.color.mainRed));


    }


    private void changeFragmentView(BaseFragment fragment) {

        ft = fm.beginTransaction();

        for (BaseFragment f :
                fragments) {
            if (f == fragment) {
                ft.show(f);
                continue;
            }
            ft.hide(f);
        }

        ft.commit();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mBottomBar.onSaveInstanceState(outState);

    }
}
