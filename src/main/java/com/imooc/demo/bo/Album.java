package com.imooc.demo.bo;

import javax.xml.crypto.Data;
import java.util.Date;

public class Album {
    private int albumId;
    private String albumName;
    private Date albumCreateTime;
    private String albumCover;
    private int userId;
    private String albumDescribtion;
    private int albumNumOfPic;
    public int getAlbumNumOfPic() {
        return albumNumOfPic;
    }

    public void setAlbumNumOfPic(int albumNumOfPic) {
        this.albumNumOfPic = albumNumOfPic;
    }


    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getAlbumCreateTime() {
        return albumCreateTime;
    }

    public void setAlbumCreateTime(Date albumCreateTime) {
        this.albumCreateTime = albumCreateTime;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAlbumDescribtion() {
        return albumDescribtion;
    }

    public void setAlbumDescribtion(String albumDescribtion) {
        this.albumDescribtion = albumDescribtion;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", albumCreateTime=" + albumCreateTime +
                ", albumCover='" + albumCover + '\'' +
                ", userId=" + userId +
                ", albumDescribtion='" + albumDescribtion + '\'' +
                ", albumNumOfPic=" + albumNumOfPic +
                '}';
    }
}
