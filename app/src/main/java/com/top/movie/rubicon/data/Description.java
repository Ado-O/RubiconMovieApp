package com.top.movie.rubicon.data;

public class Description {

    private String mName;
    private String mDesc;
    private String mImage;

    public Description(String name, String desc, String image) {
        mName = name;
        mDesc = desc;
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }
}
