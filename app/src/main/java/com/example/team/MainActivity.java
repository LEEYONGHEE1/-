package com.example.team;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.team.java.login.Home;
import com.example.team.java.login.Register;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, fi;
    EditText emi, pwd;
    FirebaseAuth firebaseAuth;
    AlertDialog.Builder dlg;
    DialogInterface.OnClickListener send;
    View myview;
    View.OnClickListener cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emi = (EditText) findViewById(R.id.email);
        pwd = (EditText) findViewById(R.id.pwd);

        b1 = (Button) findViewById(R.id.b_register);
        b2 = (Button) findViewById(R.id.b_login);
        fi = (Button) findViewById(R.id.find);

        firebaseAuth = firebaseAuth.getInstance();

        send = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                EditText femail;

                femail = (EditText) myview.findViewById(R.id.email_F);
                String s;
                s = femail.getText().toString().trim();
                firebaseAuth.sendPasswordResetEmail(s).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "전송성공", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(MainActivity.this, "전송 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        };

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emi.getText().toString().trim();
                String pass = pwd.getText().toString().trim();

                switch (view.getId()){
                    case R.id.b_login:
                        firebaseAuth.signInWithEmailAndPassword(email, pass)
                                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()) {
                                            Intent intent = new Intent(MainActivity.this, Home.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(MainActivity.this, "로그인 오류", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                        break;

                    case R.id.b_register:
                        Intent intent = new Intent(getApplicationContext(), Register.class);
                        startActivity(intent);
                        break;

                    case R.id.find:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("비밀번호 재설정");
                        myview = (View) View.inflate(getApplicationContext(), R.layout.new_password, null);
                        dlg.setView(myview);
                        dlg.setPositiveButton("전송", send);
                        dlg.show();
                        break;



                }

            }
        };
        b2.setOnClickListener(cl);
        b1.setOnClickListener(cl);
        fi.setOnClickListener(cl);
    }


}