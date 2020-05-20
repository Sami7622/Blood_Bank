package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.security.PrivateKey;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity{
    EditText email;
    EditText password;
    Button login;
    TextView login2reg;
    Button toregister;

    FirebaseAuth fauth;
    private ProgressDialog progress;
    private Bundle savedInstanceState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.editTextemail);
        password = findViewById(R.id.editTextpassword);
        login = findViewById(R.id.button);
        login2reg = findViewById(R.id.textviewlogin);
        toregister=findViewById(R.id.buttontoregister);

        fauth = FirebaseAuth.getInstance();
        progress = new ProgressDialog(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (TextUtils.isEmpty(mail)) {
                    email.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    password.setError("password is required");
                    return;
                }
                if (pass.length() < 6) {
                    password.setError("password must be >=6 characters");
                    return;
                }
                fauth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "login successful..", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), demo.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Error occured" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        toregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump();
            }
        });
    }

    private void jump() {
        Intent jump = new Intent(this,registernew.class);
        startActivity(jump);
    }


}
