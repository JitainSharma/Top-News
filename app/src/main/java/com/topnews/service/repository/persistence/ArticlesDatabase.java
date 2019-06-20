package com.topnews.service.repository.persistence;

import android.content.Context;

import com.topnews.service.model.Article;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Article.class}, version = 1)
public abstract class ArticlesDatabase extends RoomDatabase {

    private static volatile ArticlesDatabase INSTANCE;

    public abstract ArticleDao articleDao();

    public static ArticlesDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ArticlesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ArticlesDatabase.class, "Top-News.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
