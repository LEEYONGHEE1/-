package com.example.team.java.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.team.MainActivity;
import com.example.team.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private EditText email_join;
    private EditText pwd_join;
    private EditText pwd2_join,name_join;
    private Button btn;
    private ImageView back;
    FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        email_join = (EditText) findViewById(R.id.email_R);
        pwd_join = (EditText) findViewById(R.id.password_R);
        name_join=(EditText)findViewById(R.id.name_R);
        pwd2_join=(EditText)findViewById(R.id.password2_R);
        btn = (Button) findViewById(R.id.button_R);
        back = (ImageView) findViewById(R.id.back_login);


        firebaseAuth = FirebaseAuth.getInstance();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = email_join.getText().toString().trim();
                final String pwd = pwd_join.getText().toString().trim();
                final String name = name_join.getText().toString().trim();
                //공백인 부분을 제거하고 보여주는 trim();

                if(pwd_join.getText().toString().equals(pwd2_join.getText().toString())){



                    firebaseAuth.createUserWithEmailAndPassword(email, pwd)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {
                                        addData(name_join.getText().toString(), email_join.getText().toString());
                                        Intent intent = new Intent(Register.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();

                                    } else {
                                        Toast.makeText(Register.this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show();
                                        return;
                                    }
                                }
                            });

                } else {
                    Toast.makeText(Register.this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });


    }
    public void addData(String name, String email){
        Data data = new Data(name, email);

        databaseReference.child("DATA").child(user.getUid()).setValue(data);
    }
    public void hide_keyboard(View view){
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(email_join.getWindowToken(), 0);
    }


}