package org.vcmo.thisgoods.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.vcmo.thisgoods.R;
import org.vcmo.thisgoods.model.data.MainListData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jie on 2016-05-15.
 */
public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyHolder> {

    List<MainListData> datas = new ArrayList<>();

    public MyRecycleAdapter(List<MainListData> datas) {

        this.datas = datas;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_list, parent, false);

        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
//        holder.tvName.setText("eirture");
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        ImageView ivHeadIcon;
        TextView tvName;
        TextView tvPrice;
        ImageView ivImage1;
        ImageView ivImage2;
        ImageView ivImage3;

        TextView tvDescription;
        TextView tvCommentCount;


        public MyHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.info_name);
        }
    }
}
