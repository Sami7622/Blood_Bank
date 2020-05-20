package com.example.bloodbank;

public class donorsfresh {
    private String d_name,d_mnumber,d_age,d_gender,d_bloodgroup;

    public donorsfresh(){

    }

    public donorsfresh(String d_name, String d_mnumber, String d_age, String d_gender, String d_bloodgroup) {
        this.d_name = d_name;
        this.d_mnumber = d_mnumber;
        this.d_age = d_age;
        this.d_gender = d_gender;
        this.d_bloodgroup = d_bloodgroup;
    }

    public String getD_name() {
        return d_name;
    }

    public String getD_mnumber() {
        return d_mnumber;
    }

    public String getD_age() {
        return d_age;
    }

    public String getD_gender() {
        return d_gender;
    }

    public String getD_bloodgroup() {
        return d_bloodgroup;
    }
}
