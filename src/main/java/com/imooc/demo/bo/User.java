package com.imooc.demo.bo;
import java.util.Date;
//user实体类

public class User {

    private int userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private int userStatus;
    private int userSize;
    private Date userRegisterTime;
    private Date userLastLoginTime;
    private int userCode;

    public User(String userName, String userPassword, String userEmail,int userStatus,int userSize,Date userRegisterTime,Date userLastLoginTime, int userCode){
        this.userName=userName;
        this.userPassword=userPassword;
        this.userEmail=userEmail;
        this.userSize=userSize;
        this.userStatus=userStatus;
        this.userCode = userCode;
        this.userRegisterTime=userRegisterTime;
        this.userLastLoginTime=userLastLoginTime;
    }

    public User(){}
    public int getUserCode() {
        return userCode;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int getUserSize() {
        return userSize;
    }

    public void setUserSize(int userSize) {
        this.userSize = userSize;
    }

    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public Date getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Date userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userStatus=" + userStatus +
                ", userSize=" + userSize +
                ", userRegisterTime=" + userRegisterTime +
                ", userLastLoginTime=" + userLastLoginTime +
                '}';
    }
}
