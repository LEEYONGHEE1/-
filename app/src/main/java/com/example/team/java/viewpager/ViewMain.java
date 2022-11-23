package com.example.team.java.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.team.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ViewMain extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private ViewMain mContext = ViewMain.this;

    private MyFragmentStateAdapter myFragmentStateAdapter;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private  TabLayoutMediator tabLayoutMediator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);

        init();
        initAdapter();
        initTap();
    }

    private void initTap() {
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {}).attach();
        //어탭터 컬렉션 개수 만큼 for문 돌면서 만듬.
        tabLayout.getTabAt(0).setText("1");
        tabLayout.getTabAt(1).setText("2");
        tabLayout.getTabAt(2).setText("3");

    }

    private void initAdapter(){
        myFragmentStateAdapter = new MyFragmentStateAdapter(
                this
        );

        myFragmentStateAdapter.addFragment(new FragmentFirst(mContext));
        myFragmentStateAdapter.addFragment(new FragmentSecond(mContext));
        myFragmentStateAdapter.addFragment(new FragmentThird(mContext));


        viewPager2.setAdapter(myFragmentStateAdapter);
    }



    public void init(){
        viewPager2 = findViewById(R.id.vp_container);
        tabLayout = findViewById(R.id.tabLayout);
    }
}