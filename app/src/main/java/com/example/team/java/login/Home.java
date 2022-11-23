package com.example.team.java.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.team.java.show.Mypage;
import com.example.team.R;
import com.example.team.java.search.SearchListView;
import com.example.team.java.viewpager.ViewMain;
import com.example.team.kotlin.MainActivity1;
import com.example.team.kotlin.MainActivity1Kt;

public class Home extends Activity {

    Intent i;
    ImageView my,ar,av1;
    TextView ser;
    View.OnClickListener cl;

    ListView listView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        av1 = (ImageView)findViewById(R.id.allview);
        ar = (ImageView)findViewById(R.id.ar_click);
        my = (ImageView) findViewById(R.id.mypage);
        ser = (TextView) findViewById(R.id.search_b);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.mypage:
                        i = new Intent(getApplicationContext(), Mypage.class);
                        startActivity(i);
                        break;
                    case R.id.search_b:
                        i = new Intent(getApplicationContext(), SearchListView.class);
                        startActivity(i);
                        break;
                    case R.id.ar_click:
                        i = new Intent(getApplicationContext(), MainActivity1.class);
                        startActivity(i);
                        break;
                    case R.id.allview:
                        i = new Intent(getApplicationContext(), ViewMain.class);
                        startActivity(i);
                        break;
                }
            }
        };
        my.setOnClickListener(cl);
        ser.setOnClickListener(cl);
        ar.setOnClickListener(cl);
        av1.setOnClickListener(cl);

    }
}