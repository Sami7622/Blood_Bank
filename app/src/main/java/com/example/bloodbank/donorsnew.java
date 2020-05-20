package com.example.bloodbank;

public class donorsnew {
    private String NAME,ADDRESS,BLOODGROUP,GENDER;
    private Integer NUMBER,AGE;

    public donorsnew(){

    }

    public donorsnew(String NAME, String ADDRESS, String BLOODGROUP, String GENDER, Integer NUMBER, Integer AGE) {
        this.NAME = NAME;
        this.ADDRESS = ADDRESS;
        this.BLOODGROUP = BLOODGROUP;
        this.GENDER = GENDER;
        this.NUMBER = NUMBER;
        this.AGE = AGE;
    }

    public donorsnew(String name, int parseInt, int parseInt1, String bloodgroup, String gender, String address) {

    }

    public String getNAME() {
        return NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public String getBLOODGROUP() {
        return BLOODGROUP;
    }

    public String getGENDER() {
        return GENDER;
    }

    public Integer getNUMBER() {
        return NUMBER;
    }

    public Integer getAGE() {
        return AGE;
    }
}
