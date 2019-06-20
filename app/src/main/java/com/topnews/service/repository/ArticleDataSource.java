package com.topnews.service.repository;

import com.topnews.service.model.Article;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface ArticleDataSource {

    Flowable<List<Article>> getArticles();

    Completable insertOrUpdateArticles(List<Article> articles);

    void deleteArticles();
}
