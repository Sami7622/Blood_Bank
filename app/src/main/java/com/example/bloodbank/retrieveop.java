package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class retrieveop extends AppCompatActivity {

    TextView name,number,gender,bloodgroup,age;

    private FirebaseAuth firebaseAuth  = FirebaseAuth.getInstance();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieveop);
        name = findViewById(R.id.nameop);
        number = findViewById(R.id.numberop);
        gender = findViewById(R.id.genderop);
        bloodgroup = findViewById(R.id.bloodgroupop);
        age = findViewById(R.id.ageop);

        db.collection("donorsfresh")
                .whereEqualTo("d_bloodgroup", "o+")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int count=0;
                            for (QueryDocumentSnapshot document: task.getResult())
                            {

                                name.setText(document.get("d_name").toString().toUpperCase());
                                number.setText(document.get("d_mnumber").toString());
                                gender.setText(document.get("d_gender").toString());
                                bloodgroup.setText(document.get("d_bloodgroup").toString());
                                age.setText(document.get("d_age").toString());
                                count++;
                            }
                            Toast.makeText(getApplicationContext(),String.valueOf(count),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
