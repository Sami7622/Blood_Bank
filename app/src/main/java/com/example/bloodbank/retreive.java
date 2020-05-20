package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class retreive extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retreive);

    }
    public void retrive(View view) {
        Intent ret;
        ret = new Intent(this,retrieveap.class);
        startActivity(ret);

    }


    public void retrievean(View view) {
        Intent an = new Intent(this,retrievean.class);
        startActivity(an);
    }

    public void retrivebp(View view) {
        Intent bp = new Intent(this,retrievebp.class);
        startActivity(bp);
    }

    public void retrievebn(View view) {
        Intent bn = new Intent(this,retrivebn.class);
        startActivity(bn);
    }

    public void retriveop(View view) {
        Intent op = new Intent(this,retrieveop.class);
        startActivity(op);
    }

    public void retrieveon(View view) {
        Intent on = new Intent(this,retrieveon.class);
        startActivity(on);
    }

    public void retrieveabp(View view) {
        Intent abp = new Intent(this,retrieveabp.class);
        startActivity(abp);
    }

    public void retrieveabn(View view) {
        Intent abn = new Intent(this,retrieveabn.class);
        startActivity(abn);

    }
}
