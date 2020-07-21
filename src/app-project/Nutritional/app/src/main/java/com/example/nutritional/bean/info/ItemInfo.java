package com.example.nutritional.bean.info;

/**
 * @author 69182
 */
public
class ItemInfo {
    public ItemInfo(int imgId, String text) {
        this.imgId = imgId;
        this.text = text;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int imgId;
    public String text;
}
