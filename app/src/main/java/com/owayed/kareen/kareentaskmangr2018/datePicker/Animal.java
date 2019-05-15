package com.owayed.kareen.kareentaskmangr2018.datePicker;

import android.media.Image;

public class Animal {
    private String key;
    private String type;
    private String name;
    private String uid;
    private String age;
    private String Color;
    private String address;
    private String email;
    private String money;
    private Image picture;
    private String PhoneNumber;

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Animal()
    {

    }

    public static void add(MyTask task) {
    }

    public static void clear() {
    }

    public String getKey() {
        return key;
    }

    public  void setKey(String key) {
        this.key=key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName(){return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Image getPicture() {
        return picture;
    }

    public void setPicture(Image picture) {
        this.picture = picture;
    }


    @Override
    public String toString() {
        return "MyTask{" +
                "type='" + type + '\'' +
                ", age='" + age + '\'' +
                ", name='" + Color + '\'' +
                ", address=" + address +
                ", money=" + money +
                ", picture=" + picture +
                '}';
    }
    
}
