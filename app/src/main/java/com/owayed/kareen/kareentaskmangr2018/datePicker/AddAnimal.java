package com.owayed.kareen.kareentaskmangr2018.datePicker;

import android.media.Image;

public class AddAnimal {
    private String type;
    private int age;
    private String Color;
    private String address;
    private int money;
    private Image picture;

    public AddAnimal()
    {

    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
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
