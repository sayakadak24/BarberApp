package com.example.barberapp;

public class Users {
    public String mail,name,phone;

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

    public Users(String mail, String name, String phone) {
        this.mail = mail;
        this.name = name;
        this.phone = phone;
    }

    public Users() {
    }
}
