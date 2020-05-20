package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class donorfresh extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private EditText mnumber;
    private EditText age;
    private EditText gender;
    private EditText bloodgroup;
    TextView text;
    Button countd;


    private FirebaseFirestore dbms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donorfresh);

        dbms = FirebaseFirestore.getInstance();

        name = findViewById(R.id.etname);
        mnumber = findViewById(R.id.etnumber);
        age = findViewById(R.id.etage);
        gender = findViewById(R.id.etgender);
        bloodgroup = findViewById(R.id.etbgrp);
        text = findViewById(R.id.tvsymbol);
        countd = findViewById(R.id.buttoncount);

        findViewById(R.id.submitbutton).setOnClickListener(this);
    }
    private boolean validateInputs(String d_name,String d_mnumber,String d_age,String d_gender,String d_bloodgroup){
        if (d_name.isEmpty()) {
            name.setError("Name required");
            name.requestFocus();
            return true;
        }
        if (d_mnumber.isEmpty()) {
            mnumber.setError("number required");
            mnumber.requestFocus();
            return true;
        }
        if (d_age.isEmpty()) {
            age.setError("Age required");
            age.requestFocus();
            return true;
        }
        if (d_gender.isEmpty()) {
            gender.setError("gender required");
            gender.requestFocus();
            return true;
        }
        if (d_bloodgroup.isEmpty()) {
            bloodgroup.setError("bloodgroup required");
            bloodgroup.requestFocus();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {

        String d_name = name.getText().toString().trim();
        String d_mnumber = mnumber.getText().toString().trim();
        String d_age = age.getText().toString().trim();
        String d_gender = gender.getText().toString().trim();
        String d_bloodgroup = bloodgroup.getText().toString().trim();

        if (!validateInputs(d_name,d_mnumber,d_age,d_gender,d_bloodgroup)){
            CollectionReference dbmsdonors = dbms.collection("donorsfresh");

            donorsfresh donorsfresh = new donorsfresh(
                    d_name,
                    d_mnumber,
                    d_age,
                    d_gender,
                    d_bloodgroup
            );

            dbmsdonors.add(donorsfresh)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(donorfresh.this,"donor added successfully.you are now a donor.",Toast.LENGTH_SHORT).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(donorfresh.this,e.getMessage(),Toast.LENGTH_SHORT).show();



                }
            });

        }

    }
    public void count(View view) {
        dbms.collection("donorsfresh")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int count = 0;
                            for (DocumentSnapshot document : task.getResult()) {
                                count++;}

                                Toast.makeText(getApplicationContext(),String.valueOf(count),Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(donorfresh.this,"Error occured.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



}
