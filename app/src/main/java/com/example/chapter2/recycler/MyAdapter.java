package com.example.chapter2.recycler;

import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chapter2.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<TestData> mDataset = new ArrayList<>();
    private IOnItemClickListener mItemClickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
//        private TextView tvIndex;
        private TextView tvName;
        private TextView tvDate;
        private TextView tvMes;
        private ImageView ivAvatar;
        private View contentView;


        public MyViewHolder(View v) {
            super(v);
            contentView = v;
//            tvIndex = v.findViewById(R.id.tv_index);
            tvName = v.findViewById(R.id.tv_name);
            tvDate = v.findViewById(R.id.tv_date);
            tvMes = v.findViewById(R.id.tv_mes);
            ivAvatar = v.findViewById(R.id.iv_avatar);
        }

        public void onBind(int position, TestData data) {//进行数据的渲染,position是索引值
//            tvIndex.setText(new StringBuilder().append(position).append(".  ").toString());
            tvName.setText(data.name);
            tvDate.setText(data.date);
            tvMes.setText(data.mes);
            switch(position) {  //set image for each item
                case 3:
                    ivAvatar.setImageResource(R.drawable.avatar1);
                    break;
                case 4:
                    ivAvatar.setImageResource(R.drawable.avatar2);
                    break;
                case 5:
                    ivAvatar.setImageResource(R.drawable.avatar3);
                    break;
                case 6:
                    ivAvatar.setImageResource(R.drawable.avatar4);
                    break;
                case 7:
                    ivAvatar.setImageResource(R.drawable.avatar5);
                    break;
                case 8:
                    ivAvatar.setImageResource(R.drawable.avatar6);
                    break;
                case 9:
                    ivAvatar.setImageResource(R.drawable.avatar7);
                    break;
                case 10:
                    ivAvatar.setImageResource(R.drawable.avatar8);
                    break;
                default:
                    ivAvatar.setImageResource(R.drawable.douyin);
                    break;
            }
//            if (position < 3) {
//                tvIndex.setTextColor(Color.parseColor("#FFD700"));
//            } else {
//                tvIndex.setTextColor(Color.parseColor("#FFFFFF"));
//            }
        }

        public void setOnClickListener(View.OnClickListener listener) {
            if (listener != null) {
                contentView.setOnClickListener(listener);
            }
        }

        public void setOnLongClickListener(View.OnLongClickListener listener) {
            if (listener != null) {
                contentView.setOnLongClickListener(listener);
            }
        }
    }


    public MyAdapter(List<TestData> myDataset) {
        mDataset.addAll(myDataset);
    }

    public void setOnItemClickListener(IOnItemClickListener listener) {
        mItemClickListener = listener;
    }

    public void addData(int position, TestData data) {
        mDataset.add(position, data);
        notifyItemInserted(position);
        if (position != mDataset.size()) {
            //刷新改变位置item下方的所有Item的位置,避免索引错乱
            notifyItemRangeChanged(position, mDataset.size() - position);
        }
    }

    public void removeData(int position) {
        if (null != mDataset && mDataset.size() > position) {
            mDataset.remove(position);
            notifyItemRemoved(position);
            if (position != mDataset.size()) {
                //刷新改变位置item下方的所有Item的位置,避免索引错乱
                notifyItemRangeChanged(position, mDataset.size() - position);
            }
        }
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())//把layout转换成我们需要的view
                .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.onBind(position, mDataset.get(position));
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemCLick(position, mDataset.get(position));
                }
            }
        });
//        holder.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                if (mItemClickListener != null) {
////                    mItemClickListener.onItemLongCLick(position, mDataset.get(position));
//                }
//                return false;
//            }
//
//        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface IOnItemClickListener {

        void onItemCLick(int position, TestData data);

//        void onItemLongCLick(int position, TestData data);
    }
}
