package com.example.team.java.show;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.team.MainActivity;
import com.example.team.R;
import com.example.team.java.login.Delete;
import com.example.team.java.login.Profile;
import com.google.firebase.auth.FirebaseAuth;

public class Mypage extends Activity {
    Intent i;
    TextView pro, out, del;
    View.OnClickListener cl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        pro = (TextView) findViewById(R.id.profile);
        out = (TextView) findViewById(R.id.logout);
        del = (TextView) findViewById(R.id.go_delete);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.profile:
                        i = new Intent(getApplicationContext(), Profile.class);
                        startActivity(i);
                        break;
                    case R.id.logout:
                        FirebaseAuth.getInstance().signOut();
                        i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        break;
                    case R.id.go_delete:
                        i = new Intent(getApplicationContext(), Delete.class);
                        startActivity(i);
                        break;
                }
            }
        };
        pro.setOnClickListener(cl);
        out.setOnClickListener(cl);
        del.setOnClickListener(cl);
    }
}