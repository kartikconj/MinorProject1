package com.example.minorproject;

public class register {
    String userid,password, aut;
    public register()
    {}
public register(String userid, String password, String aut){
    this.userid=userid;
    this.password=password;
    this.aut=aut;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getAut() {
        return aut;
    }
}
