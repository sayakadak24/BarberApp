package com.example.barberapp;

public class Users {
    public String mail,name,phone,uid;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Users() {
    }

    public Users(String mail, String name, String phone, String uid) {
        this.mail = mail;
        this.name = name;
        this.phone = phone;
        this.uid = uid;
    }
}
