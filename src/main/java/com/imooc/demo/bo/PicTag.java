package com.imooc.demo.bo;

public class PicTag {
    private Integer ptId;
    private Integer pictureId;
    private Integer tagId;

    public Integer getPtId() {
        return ptId;
    }

    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "PicTag{" +
                "ptId=" + ptId +
                ", pictureId=" + pictureId +
                ", tagId=" + tagId +
                '}';
    }
}
