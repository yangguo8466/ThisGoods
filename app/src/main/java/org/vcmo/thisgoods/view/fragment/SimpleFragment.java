package org.vcmo.thisgoods.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.vcmo.thisgoods.R;
import org.vcmo.thisgoods.view.base.BaseFragment;

/**
 * Created by Jie on 2016-05-12.
 */
public class SimpleFragment extends BaseFragment {


    private String strContent;
    private View root;
    private TextView tvMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_simple_layout, container, false);
        tvMessage = (TextView) root.findViewById(R.id.simple_text);

        tvMessage.setText(strContent);
        return root;

    }

    public static SimpleFragment newInstance(String str) {

        Bundle args = new Bundle();

        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(args);
        fragment.strContent = str;

        return fragment;
    }

}
