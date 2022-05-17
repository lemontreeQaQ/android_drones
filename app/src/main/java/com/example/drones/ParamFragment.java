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

import org.greenrobot.eventbus.EventBus;

public class ParamFragment extends Fragment {

    private Button confirm;
    private Button back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_param, container, false);
        confirm = view.findViewById(R.id.param_confirm);
        back = view.findViewById(R.id.param_back);
        init(view);
        return view;
    }

    private void init(View view) {
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(Event.getInstance("route"));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(Event.getInstance("bridge"));
            }
        });
    }
}
