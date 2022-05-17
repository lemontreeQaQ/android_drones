package com.example.drones;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.drones.utils.Event;
import com.example.drones.view.SearchView;

import org.greenrobot.eventbus.EventBus;


/**
 * @author Evan_zch
 * @date 2018/8/23 20:41
 */
public class BridgeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bridge, container, false);
        SearchView sv = (SearchView) view.findViewById(R.id.search_view);
        sv.setSwitchListener(new SearchView.SwitchListener() {
            @Override
            public void onClick() {
//                switchFragment(new RouteFragment());
                EventBus.getDefault().post(Event.getInstance("param"));
            }
        });
        return view;
    }

//    private void switchFragment(Fragment targetFragment) {
//        if (targetFragment == null)
//            return;
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        //目标Fragment替换原来的Fragment
//        transaction.replace(R.id.detect_layout, targetFragment);
//        transaction.commit();
//    }
}
