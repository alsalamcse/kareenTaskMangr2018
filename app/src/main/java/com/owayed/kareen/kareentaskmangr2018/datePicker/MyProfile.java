package com.owayed.kareen.kareentaskmangr2018.datePicker;

import android.graphics.Color;

public class MyProfile {

    private String name;
    private String PhoneNumber;
    private String Email;
    private String Age;
    private String key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "MyProfile{" +
                "name='" + name + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Email='" + Email + '\'' +
                ", Age='" + Age + '\'' +
                '}';
    }

    public void setKey(String key) {
        this.key=key;
    }
}
