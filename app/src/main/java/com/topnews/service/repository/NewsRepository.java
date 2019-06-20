package com.topnews.service.repository;

import com.topnews.BuildConfig;
import com.topnews.service.model.Article;
import com.topnews.service.repository.persistence.ArticleDao;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class NewsRepository {

    @Inject
    ArticleDao mArticleDao;
    @Inject
    NewsService mNewsService;

    public NewsRepository() {
    }

    public Observable<List<Article>> getTopNews() {

        return Observable.concatArrayEager(
                mArticleDao.getArticles().toObservable(),

                mNewsService.countryTopHeadlines("in", BuildConfig.API_KEY)
                        .map(newsResponse -> {

                            if (newsResponse.status.equalsIgnoreCase("ok"))
                                return newsResponse.articles;

                            throw new Exception(newsResponse.message);
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .debounce(400, MILLISECONDS));
    }

}
