package com.owayed.kareen.kareentaskmangr2018.datePicker;

import android.graphics.Color;

public class MyProfile {

    private String name;
    private String PhoneNumber;
    private String Email;
    private String Age;
    private String Color;
    private String Address;
    private String Money;

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

    public String getColor() {
        return Color;
    }

    public String getMoney() {
        return Money;
    }

    public String getAddress() {
        return Address;
    }
}
