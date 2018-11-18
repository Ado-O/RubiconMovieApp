package com.top.movie.rubicon.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Search implements Parcelable {

    private String mName;
    private long mId;
    private String mImage;
    private String mDesc;

    public Search(String name, long id, String image, String desc) {
        mName = name;
        mId = id;
        mImage = image;
        mDesc = desc;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }


    protected Search(Parcel in) {
        mName = in.readString();
        mId = in.readLong();
        mImage = in.readString();
        mDesc = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeLong(mId);
        dest.writeString(mImage);
        dest.writeString(mDesc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Search> CREATOR = new Creator<Search>() {
        @Override
        public Search createFromParcel(Parcel in) {
            return new Search(in);
        }

        @Override
        public Search[] newArray(int size) {
            return new Search[size];
        }
    };
}
