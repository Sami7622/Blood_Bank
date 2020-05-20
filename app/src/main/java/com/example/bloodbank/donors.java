package com.example.bloodbank;

public class donors {
    private String NAME,ADDRESS,BLOODGROUP,GENDER;
    private Number NUMBER,AGE;

    public donors(String NAME, int i, int parseInt,String BLOODGROUP,String GENDER,String ADDRESS){

    }

    public donors(String NAME,Number NUMBER, Number AGE,String GENDER,String ADDRESS) {
        this.NAME = NAME;
        this.NUMBER = NUMBER;
        this.AGE = AGE;
        this.BLOODGROUP=BLOODGROUP;
        this.GENDER=GENDER;
        this.ADDRESS = ADDRESS;
    }

    public String getNAME() {
        return NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public Number getNUMBER() {
        return NUMBER;
    }
    public String getBLOODGROUP(){
        return BLOODGROUP;
    }
    public String getGENDER(){
        return GENDER;
    }

    public Number getAGE() {
        return AGE;
    }
}
