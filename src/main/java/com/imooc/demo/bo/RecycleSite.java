package com.imooc.demo.bo;

import java.util.Date;

public class RecycleSite {
    private int recycleId;
    private int pictureId;
    private int userId;
    private Date pictureDeleteTime;

    public int getRecycleId() {
        return recycleId;
    }

    public void setRecycleId(int recycleId) {
        this.recycleId = recycleId;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getPictureDeleteTime() {
        return pictureDeleteTime;
    }

    public void setPictureDeleteTime(Date pictureDeleteTime) {
        this.pictureDeleteTime = pictureDeleteTime;
    }



    @Override
    public String toString() {
        return "RecycleSite{" +
                "recycleId=" + recycleId +
                ", pictureId=" + pictureId +
                ", userId=" + userId +
                ", pictureDeleteTime=" + pictureDeleteTime +
                '}';
    }
}
