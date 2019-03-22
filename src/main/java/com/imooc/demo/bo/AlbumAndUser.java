package com.imooc.demo.bo;
//相册表和用户表的结合即vo层
public class AlbumAndUser {
    private Integer userId;
    private String userName;
    private String userEmail;
    private Integer albumNumOfPic;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAlbumNumOfPic() {
        return albumNumOfPic;
    }

    public void setAlbumNumOfPic(Integer albumNumOfPic) {
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
