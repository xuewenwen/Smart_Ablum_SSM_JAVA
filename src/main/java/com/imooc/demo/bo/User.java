package com.imooc.demo.bo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class User {
    private int user_id;
    private String user_name;
    private String password;
    private String email;
    private int user_state;
    private int user_size;
    private Date user_time;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUser_state() {
        return user_state;
    }

    public void setUser_state(int user_state) {
        this.user_state = user_state;
    }

    public int getUser_size() {
        return user_size;
    }

    public void setUser_size(int user_size) {
        this.user_size = user_size;
    }

    public Date getUser_time() {
        return user_time;
    }

    public void setUser_time(Date user_time) {
        this.user_time = user_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", user_state=" + user_state +
                ", user_size=" + user_size +
                ", user_time=" + user_time +
                '}';
    }
}
