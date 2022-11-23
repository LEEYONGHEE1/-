package com.example.team.java.viewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.team.R;
import com.example.team.java.viewpager.ViewMain;


public class FragmentFirst extends Fragment {
    private static final String TAG = "FragmentFirst";
    private ViewMain mContext;

    public FragmentFirst(ViewMain mContext){
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_first, container, false);
    }
}