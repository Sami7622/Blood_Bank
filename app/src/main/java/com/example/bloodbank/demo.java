package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class demo extends AppCompatActivity {


    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore db =FirebaseFirestore.getInstance();

    TextView textViewwel;
    TextView textViewdia;
    TextView textViewque;
    Button dbutton;
    Button rbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        dbutton=findViewById(R.id.dbutton);
        dbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendonor();
            }
        });
        rbutton=findViewById(R.id.rbutton);
        rbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openretreive();
            }
        });
    }

    public void opendonor()
    {
        Intent don = new Intent(this,donorfresh.class);
        startActivity(don);
    }

    public void openretreive()
    {
        Intent ret = new Intent(this,retreive.class);
        startActivity(ret);
    }


}
