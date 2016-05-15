package org.vcmo.thisgoods.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.vcmo.thisgoods.R;
import org.vcmo.thisgoods.model.data.MainListData;
import org.vcmo.thisgoods.view.adapter.MyRecycleAdapter;
import org.vcmo.thisgoods.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jie on 2016-05-15.
 */
public class MainFragment extends BaseFragment {


    private static final String TAG = MainFragment.class.getSimpleName();

    View root;

    RecyclerView rvContent;

    MyRecycleAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_main, container, false);

            initView();


        }

        init();

        return root;
    }

    private void initView() {

        rvContent = (RecyclerView) root.findViewById(R.id.rv_content);
        rvContent.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void init() {


        List<MainListData> datas = new ArrayList<>();

        MainListData data;
        for (int i = 0; i < 10; i++) {
            data = new MainListData();
            datas.add(data);
        }

        mAdapter = new MyRecycleAdapter(datas);

        mAdapter.setItemListener(new MyRecycleAdapter.OnRecyclerItemListener() {
            @Override
            public void onClick(View view, int position) {
                Log.d(TAG, "onClick: " + position);
            }
        });

        rvContent.setAdapter(mAdapter);
    }


    public void goToTop() {
        if (rvContent == null)
            return;

        rvContent.smoothScrollToPosition(0);
    }


    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;

    }

}
