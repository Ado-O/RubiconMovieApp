package com.top.movie.rubicon.data;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {

    private String mName;
    private long mId;
    private String mDesc;
    private String mImage;

    public TvShow(String name, long id, String desc, String image) {
        mName = name;
        mId = id;
        mDesc = desc;
        mImage = image;
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


    protected TvShow(Parcel in) {
        mName = in.readString();
        mId = in.readLong();
        mDesc = in.readString();
        mImage = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeLong(mId);
        dest.writeString(mDesc);
        dest.writeString(mImage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

}
