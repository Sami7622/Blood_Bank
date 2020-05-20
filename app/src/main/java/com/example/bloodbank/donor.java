package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class donor extends AppCompatActivity implements View.OnClickListener{
    private EditText name;
    private EditText number;
    private EditText age;
    private EditText address;
    private EditText gender;
    private EditText bloodgrp;


    private FirebaseFirestore dbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);
        dbs = FirebaseFirestore.getInstance();

        name = (EditText) findViewById(R.id.etname);
        number = (EditText) findViewById(R.id.editTextnum);
        age = (EditText) findViewById(R.id.editTextage);
        address = (EditText) findViewById(R.id.editTextaddress);
        bloodgrp = (EditText) findViewById(R.id.editTextbgrp);
        gender = (EditText) findViewById(R.id.editTextgender);


        findViewById(R.id.buttonsub).setOnClickListener((View.OnClickListener) donor.this);


    }



    private boolean validateInputs(String NAME,String NUMBER,String AGE,String BLOODGROUP,String GENDER,String ADDRESS){
        if (NAME.isEmpty()){
            name.setError("name required");
            name.requestFocus();
            return true;
        }
        if (NUMBER.isEmpty()){
            number.setError("number required");
            number.requestFocus();
            return true;
        }
        if (AGE.isEmpty()){
            age.setError("age required");
            age.requestFocus();
            return true;
        }
        if (BLOODGROUP.isEmpty()){
            bloodgrp.setError("blood group required");
            bloodgrp.requestFocus();
            return true;
        }
        if (GENDER.isEmpty()){
            gender.setError("gender required");
            gender.requestFocus();
            return true;
        }
        if (ADDRESS.isEmpty()){
            address.setError("address required");
            address.requestFocus();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        String NAME = name.getText().toString().trim();
        String NUMBER = number.getText().toString().trim();
        String AGE = age.getText().toString().trim();
        String BLOODGROUP = bloodgrp.getText().toString().trim();
        String GENDER = gender.getText().toString().trim();
        String ADDRESS = address.getText().toString().trim();

        if (!validateInputs(NAME,NUMBER,AGE,BLOODGROUP,GENDER,ADDRESS)){

            CollectionReference dbsdonors = dbs.collection("DONORS_NEW");
           donorsnew donorsnew = new donorsnew(
                   NAME,
                   Integer.parseInt(NUMBER),
                   Integer.parseInt(AGE),
                   BLOODGROUP,
                   GENDER,
                   ADDRESS
           );
            dbsdonors.add(donorsnew)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(donor.this,"Congrats..you are now a donor.",Toast.LENGTH_LONG).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(donor.this,e.getMessage(),Toast.LENGTH_LONG).show();

                }
            });

        }

    }


}
