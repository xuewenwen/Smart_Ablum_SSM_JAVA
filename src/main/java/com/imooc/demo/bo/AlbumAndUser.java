package com.imooc.demo.bo;
//相册表和用户表的结合即vo层
public class AlbumAndUser {
    private int userId;
    private String userName;
    private String userEmail;
    private int albumNumOfPic;

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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getAlbumNumOfPic() {
        return albumNumOfPic;
    }

    public void setAlbumNumOfPic(int albumNumOfPic) {
        this.albumNumOfPic = albumNumOfPic;
    }

    @Override
    public String toString() {
        return "AlbumAndUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", albumNumOfPic=" + albumNumOfPic +
                '}';
    }
}
