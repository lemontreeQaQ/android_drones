package com.example.drones;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drones.adapters.GridViewAdapter;
import com.example.drones.beans.ItemBean;
import com.example.drones.utils.Datas;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evan_zch
 * @date 2018/8/23 20:40
 */
public class TypeFragment extends Fragment {

    private RecyclerView list;
    private List<ItemBean> datas;
    private GridViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_type, container, false);
        //找到控件
        list = (RecyclerView) view.findViewById(R.id.recyclerView);
        //准备数据
        initData();

        initListner();
        return  view;
    }

    private void initListner() {
        adapter.setOnItemClickListener(new GridViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //处理点击条目的事件
                Toast.makeText(getContext(),"土司"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        //创建数据
        datas = new ArrayList<>();
        //模拟数据
        for(int i=0;i< Datas.icons.length;i++){
            //创建数据对象
            ItemBean data = new ItemBean();
            data.icon = Datas.icons[i];
            data.type = Datas.types[i];
            data.desc = Datas.descs[i];
            datas.add(data);
        }

        //创建布局管理器
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        list.setLayoutManager(layoutManager);

        //创建适配器
        adapter = new GridViewAdapter(datas);

        //设置适配器
        list.setAdapter(adapter);
    }
}
