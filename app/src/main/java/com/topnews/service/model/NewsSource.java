package com.topnews.service.model;

import androidx.room.ColumnInfo;

public class NewsSource {

    @ColumnInfo(name = "sourceid")
    public String id;

    @ColumnInfo(name = "sourcename")
    public String name;

}
