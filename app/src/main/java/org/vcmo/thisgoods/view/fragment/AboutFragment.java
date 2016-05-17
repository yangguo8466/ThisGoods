package org.vcmo.thisgoods.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.vcmo.thisgoods.R;
import org.vcmo.thisgoods.view.base.BaseFragment;

/**
 * Created by Jie on 2016-05-15.
 */
public class AboutFragment extends BaseFragment {


    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_about_layout, container, false);

        return root;

    }

    public static AboutFragment newInstance() {

        Bundle args = new Bundle();

        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
