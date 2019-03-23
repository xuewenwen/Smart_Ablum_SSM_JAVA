package com.imooc.demo.bo;

import java.util.Date;

public class Picture {
    private int pictureId;
    private int albumId;
    private String pictureName;
    private Date pictureCreateTime;
    private String pictureUrl;
    private String pictureTag;
    private int pictureSize;
    private int pictureStatus;
    private String pictureThumbnaill;
    private  String pictureDescribtion;

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }



    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureTag() {
        return pictureTag;
    }

    public void setPictureTag(String pictureTag) {
        this.pictureTag = pictureTag;
    }

    public int getPictureSize() {
        return pictureSize;
    }

    public void setPictureSize(int pictureSize) {
        this.pictureSize = pictureSize;
    }

    public Date getPictureCreateTime() {
        return pictureCreateTime;
    }

    public void setPictureCreateTime(Date pictureCreateTime) {
        this.pictureCreateTime = pictureCreateTime;
    }

    public int getPictureStatus() {
        return pictureStatus;
    }

    public void setPictureStatus(int pictureStatus) {
        this.pictureStatus = pictureStatus;
    }

    public String getPictureThumbnaill() {
        return pictureThumbnaill;
    }

    public void setPictureThumbnaill(String pictureThumbnaill) {
        this.pictureThumbnaill = pictureThumbnaill;
    }

    public String getPictureDescribtion() {
        return pictureDescribtion;
    }

    public void setPictureDescribtion(String pictureDescribtion) {
        this.pictureDescribtion = pictureDescribtion;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pictureId=" + pictureId +
                ", albumId=" + albumId +
                ", pictureName='" + pictureName + '\'' +
                ", pictureCreateTime=" + pictureCreateTime +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", pictureTag='" + pictureTag + '\'' +
                ", pictureSize=" + pictureSize +
                ", pictureStatus=" + pictureStatus +
                ", pictureThumbnaill='" + pictureThumbnaill + '\'' +
                ", pictureDescribtion='" + pictureDescribtion + '\'' +
                '}';
    }
}
