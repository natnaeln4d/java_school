package com.example.sampleproject;

public class Students {
    String id=null;
    String firstname=null;
    String lastname=null;
    String sex=null;
    String field=null;
    String year=null;
    public Students(String id,String firstname,String lastname,String sex,String field,String year){
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.sex=sex;
        this.field=field;
        this.year=year;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex=sex;
    }
    public String getField(String field){
        return field;
    }
    public void setField(String field){
        this.field=field;
    }
    public String getYear(String year){
        return year;
    }
    public void setYear(String year){
        this.year=year;
    }


}
