package com.top.movie.rubicon.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private String mName;
    private long mId;
    private String mDesc;
    private String mImage;

    public Movie(String name, long id, String desc, String image) {
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

    protected Movie(Parcel in) {
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

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

}
