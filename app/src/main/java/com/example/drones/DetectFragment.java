package com.example.drones;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.drones.view.SearchView;


/**
 * @author Evan_zch
 * @date 2018/8/23 20:41
 */
public class DetectFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detect, container, false);
        SearchView sv = (SearchView) view.findViewById(R.id.search_view);
        return view;
    }
}
