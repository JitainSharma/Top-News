package com.topnews.service.repository;

import android.util.Log;

import com.topnews.BuildConfig;
import com.topnews.service.model.Article;
import com.topnews.service.repository.persistence.ArticleDao;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

public class NewsRepository {

    private final ArticleDao mArticleDao;
    private final NewsService mNewsService;

    @Inject
    public NewsRepository(ArticleDao mArticleDao, NewsService mNewsService) {

        this.mArticleDao = mArticleDao;
        this.mNewsService = mNewsService;

    }

    public Observable<List<Article>> getTopNews() {

        return Observable.mergeDelayError(
                mArticleDao.getArticles()
                        .subscribeOn(Schedulers.computation()),
                mNewsService.countryTopHeadlines("in", BuildConfig.API_KEY)
                        .doOnNext(newsResponse -> {

                            //Save data in Disk cache
                            if (newsResponse.status.equalsIgnoreCase("ok")
                                    && !newsResponse.articles.isEmpty()) {
                                mArticleDao.deleteArticles();
                                mArticleDao.insertArticles(newsResponse.articles)
                                        .subscribe(
                                                new DisposableCompletableObserver() {
                                                    @Override
                                                    public void onStart() {
                                                    }

                                                    @Override
                                                    public void onError(Throwable error) {
                                                        error.printStackTrace();
                                                    }

                                                    @Override
                                                    public void onComplete() {
                                                    }
                                                });
                            }

                        })
                        .map(newsResponse -> {

                            if (newsResponse.status.equalsIgnoreCase("ok"))
                                return newsResponse.articles;

                            throw new Exception(newsResponse.message);
                        }).subscribeOn(Schedulers.io())
        );

    }

}
