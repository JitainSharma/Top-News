package com.topnews.service.repository.persistence;

import com.topnews.service.model.Article;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM Articles LIMIT 20")
    Flowable<List<Article>> getArticles();

    @Insert
    Completable insertArticles(List<Article> articles);

    @Query("DELETE FROM Articles")
    void deleteArticles();
}
