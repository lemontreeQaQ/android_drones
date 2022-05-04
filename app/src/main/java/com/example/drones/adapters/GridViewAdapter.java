package com.example.drones.adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drones.MainActivity;
import com.example.drones.R;
import com.example.drones.beans.ItemBean;

import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.InnerHolder> {

    private List<ItemBean> mData;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private int selectIndex = -1;

    public GridViewAdapter(List<ItemBean> datas){
        this.mData = datas;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_grid_view,null);
        mContext = parent.getContext();
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //绑定数据
        holder.setData(mData.get(position),position);
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public void setOnItemClickListener(OnItemClickListener listner) {
        //设置一个监听
        this.mOnItemClickListener = listner;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public class InnerHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView title2;
        private ImageView icon;
        private String type;
        private String desc;
        private final ImageView check;
        private int position;


        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.grid_view_title);
            title2 = itemView.findViewById(R.id.grid_view_title2);
            icon = itemView.findViewById(R.id.grid_view_icon);
            check = itemView.findViewById(R.id.grid_view_check);
            title2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(mContext)
                            .setTitle(type)
                            .setMessage(desc)
                            .show();

                }
            });
            icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectIndex = position;
                    notifyDataSetChanged();
                }
            });
        }

        public void setData(ItemBean itemBean,int position) {
            this.position = position;
            type = itemBean.type;
            desc = itemBean.desc;
            title.setText(type);
            icon.setImageResource(itemBean.icon);
            if(selectIndex == position){
                check.setVisibility(View.VISIBLE);
            }else{
                check.setVisibility(View.INVISIBLE);
            }
        }
    }
}
