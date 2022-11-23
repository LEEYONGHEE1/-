package com.example.team.java.viewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.team.R;
import com.example.team.java.viewpager.ViewMain;


public class FragmentSecond extends Fragment {
    private static final String TAG = "FragmentSecond";
    private ViewMain mContext;

    public FragmentSecond(ViewMain mContext){
        this.mContext = mContext;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
}