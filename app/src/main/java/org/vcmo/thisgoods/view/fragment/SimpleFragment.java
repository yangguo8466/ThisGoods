package org.vcmo.thisgoods.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.vcmo.thisgoods.view.base.BaseFragment;

/**
 * Created by Jie on 2016-05-12.
 */
public class SimpleFragment extends BaseFragment {

    private String strContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        TextView tvContent = new TextView(getContext());
        tvContent.setText(strContent);
        return tvContent;

    }

    public static SimpleFragment newInstance(String str) {

        Bundle args = new Bundle();

        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(args);
        fragment.strContent = str;

        return fragment;
    }

}
