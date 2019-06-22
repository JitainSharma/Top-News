package com.topnews.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.topnews.service.utils.DateUtil;
import com.topnews.service.utils.ParcelableUtils;

import java.text.ParseException;
import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Articles")
public class Article implements Parcelable {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    public String mId = UUID.randomUUID().toString();

    @Embedded
    private NewsSource source;

    @ColumnInfo(name = "author")
    private String author;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "url")
    private String url;

    @ColumnInfo(name = "urlToImage")
    private String urlToImage;

    @ColumnInfo(name = "publishedAt")
    private String publishedAt;

    @ColumnInfo(name = "content")
    private String content;

    public Article(){}

    protected Article(Parcel in) {

        mId = in.readString();

        String id = ParcelableUtils.readString(in);
        String name = ParcelableUtils.readString(in);

        source = new NewsSource();
        source.id = id;
        source.name = name;

        author = ParcelableUtils.readString(in);

        title = in.readString();

        description = ParcelableUtils.readString(in);
        url = ParcelableUtils.readString(in);
        urlToImage = ParcelableUtils.readString(in);

        publishedAt = in.readString();

        content = ParcelableUtils.readString(in);
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    @NonNull
    public String getmId() {
        return mId;
    }

    public NewsSource getSource() {
        return source;
    }

    public void setSource(NewsSource source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewsDateString() {

        try {
            return DateUtil.convertDateFormat(getPublishedAt());
        } catch (ParseException e) {
            Log.e("Date Conversation", "", e);
        }

        return getPublishedAt();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(mId);

        ParcelableUtils.write(dest, source.id);
        ParcelableUtils.write(dest, source.name);

        ParcelableUtils.write(dest, author);

        dest.writeString(title);

        ParcelableUtils.write(dest, description);
        ParcelableUtils.write(dest, url);
        ParcelableUtils.write(dest, urlToImage);

        dest.writeString(publishedAt);

        ParcelableUtils.write(dest, content);
    }
}
