package com.imooc.demo.bo;

import java.util.Date;

public class rec {
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(String picture_id) {
        this.picture_id = picture_id;
    }

    public Date getDel_time() {
        return del_time;
    }

    public void setDel_time(Date del_time) {
        this.del_time = del_time;
    }

    // 用户id
    private Integer user_id;
    // 图片id
    private String picture_id;
    // 删除时间
    private Date del_time;



}
