package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity  {

    EditText regfullname,regemail,regpassword,regnumber;
    Button regbutton;
    TextView regtologin;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regfullname = findViewById(R.id.etname);
        regemail = findViewById(R.id.etmail);
        regpassword = findViewById(R.id.etpassword);
        regnumber = findViewById(R.id.etnumber);
        regbutton = findViewById(R.id.buttonreg);
        regtologin = findViewById(R.id.textviewlogin);

        fauth = FirebaseAuth.getInstance();

        if (fauth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),demo.class));
            finish();
        }

        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = regemail.getText().toString().trim();
                String password = regpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    regemail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    regpassword.setError("password is required");
                    return;
                }
                if (password.length() < 6){
                    regpassword.setError("password must be >=6 characters");
                    return;
                }
                fauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(register.this,"User created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),demo.class));
                        }else{
                            Toast.makeText(register.this,"Error occured"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        regtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}
