package com.example.team.java.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

//FragmentPagerAdapter => 모두 메모리에 올리고 화면 변경되어도 재사용
//FragmentStatePagerAdapter => 내가 선택된 메뉴 양옆으로 메모리에 올린다.

public class MyFragmentStateAdapter extends FragmentStateAdapter {

    private List<Fragment> mFragmentList = new ArrayList<>();

    public MyFragmentStateAdapter(@NonNull  FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public void addFragment(Fragment fragment){
        this.mFragmentList.add(fragment);
    }


    //getItem();
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return mFragmentList.size();
    }
}