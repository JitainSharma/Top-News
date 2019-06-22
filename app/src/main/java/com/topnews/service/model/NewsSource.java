package com.topnews.service.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;

public class NewsSource implements Parcelable {

    @ColumnInfo(name = "sourceid")
    public String id;

    @ColumnInfo(name = "sourcename")
    public String name;

    public NewsSource(){}

    protected NewsSource(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public static final Creator<NewsSource> CREATOR = new Creator<NewsSource>() {
        @Override
        public NewsSource createFromParcel(Parcel in) {
            return new NewsSource(in);
        }

        @Override
        public NewsSource[] newArray(int size) {
            return new NewsSource[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
    }
}
