package com.example.drones;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.drones.utils.Event;
import com.example.drones.view.SearchView;

import org.greenrobot.eventbus.EventBus;

public class RouteFragment extends Fragment {

    private ImageView iv;
    private Button confirm;
    private Button switch1;
    private String switch_flag = "route1";
    private Button back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_route, container, false);
        iv = view.findViewById(R.id.route_img);
        switch1 = view.findViewById(R.id.route_switch);
        back = view.findViewById(R.id.route_back);
        init(view);
        return view;
    }

    private void init(View view) {
        iv.setImageResource(R.drawable.route1);
        switch_flag = "route1";
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("route1".equals(switch_flag)){
                    iv.setImageResource(R.drawable.route2);
                    switch_flag = "route2";
                }else if("route2".equals(switch_flag)){
                    iv.setImageResource(R.drawable.route1);
                    switch_flag = "route1";
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(Event.getInstance("param"));
            }
        });
    }
}
