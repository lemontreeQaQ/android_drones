package com.example.drones;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.drones.utils.Event;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class DetectFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detect, container, false);
        init();
        return view;
    }

    private void init() {
        switchFragment(new BridgeFragment());
    }

    private void switchFragment(Fragment targetFragment) {
        if (targetFragment == null)
            return;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //目标Fragment替换原来的Fragment
        transaction.replace(R.id.frame, targetFragment);
        transaction.commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        //注册eventbus
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEvent(Event event){
        if("route".equals(event.getMsg())){
            switchFragment(new RouteFragment());
        }else if("bridge".equals(event.getMsg())){
            switchFragment(new BridgeFragment());
        }else if("param".equals(event.getMsg())){
            switchFragment(new ParamFragment());
        }
    }
}
