package com.example.wasee.onlinerepeat;

public class User {

    String Name, Address, gender,date,type,batch;

    public User() {
    }


    public User(String name, String address, String gender, String date, String type, String batch) {
        Name = name;
        Address = address;
        this.gender = gender;
        this.date = date;
        this.type = type;
        this.batch = batch;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
