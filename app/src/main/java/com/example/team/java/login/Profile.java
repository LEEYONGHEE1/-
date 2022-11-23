package com.example.team.java.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.team.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends Activity {

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    TextView uemail, uname;
    String email;
    EditText p1, p2;
    Button ch;
    View.OnClickListener cl;
    String password;
    String uid = user != null ? user.getUid() : null;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        uemail = (TextView) findViewById(R.id.u_email);
        uname = (TextView) findViewById(R.id.u_name);
        p1 = (EditText) findViewById(R.id.password1_C);
        p2 = (EditText) findViewById(R.id.password2_C);
        ch = (Button) findViewById(R.id.change);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        DatabaseReference nick = mDatabase.child("DATA").child(uid).child("name");



        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.change:
                        password = p2.getText().toString();
                        if(p1.getText().toString().equals(p2.getText().toString())){
                            user.updatePassword(password).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(Profile.this, "변경완료", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                }
            }
        };
        ch.setOnClickListener(cl);

        nick.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String nickname = snapshot.getValue(String.class);
                uname.setText(nickname);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        if (user != null){
            email = user.getEmail();
        }

        uemail.setText(email);

    }
}