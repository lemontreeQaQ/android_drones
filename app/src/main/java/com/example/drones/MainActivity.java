package com.example.drones;


import android.os.Bundle;

import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Evan_zch
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private BottomNavigationView mBottomNavigationView;

    private int lastIndex;
    List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initBottomNavigation();
        initData();

    }

    public void initView() {
        mToolbar = findViewById(R.id.toolbar);

    }

    public void initData() {
        setSupportActionBar(mToolbar);
        mFragments = new ArrayList<>();
        mFragments.add(new WeatherFragment());
        mFragments.add(new TypeFragment());
        mFragments.add(new DetectFragment());
        mFragments.add(new LocationFragment());
        mFragments.add(new MineFragment());

        // 初始化展示MessageFragment
        setFragmentPosition(0);
    }

    public void initBottomNavigation() {
        mBottomNavigationView = findViewById(R.id.bv_bottomNavigation);
        // 解决当item大于三个时，非平均布局问题
        //BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_weather:
                        setFragmentPosition(0);
                        break;
                    case R.id.menu_type:
                        setFragmentPosition(1);
                        break;
                    case R.id.menu_detect:
                        setFragmentPosition(2);
                        break;
                    case R.id.menu_location:
                        setFragmentPosition(3);
                        break;
                    case R.id.menu_mine:
                        setFragmentPosition(4);
                        break;

                    default:
                        break;
                }
                // 这里注意返回true,否则点击失效
                return true;
            }
        });
    }


    private void setFragmentPosition(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = mFragments.get(position);
        Fragment lastFragment = mFragments.get(lastIndex);
        lastIndex = position;
        ft.hide(lastFragment);
        if (!currentFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.ll_frameLayout, currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }
}
