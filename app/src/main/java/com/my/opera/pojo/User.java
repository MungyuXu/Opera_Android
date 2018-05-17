package com.my.opera.pojo;

/**
 * Created by MY on 2018/5/6.
 */

public class User {
    private int id;
    private String username;
    private String address;
    private String pwd;

    public User() {
    }

    public User(int id, String username, String address, String pwd) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
