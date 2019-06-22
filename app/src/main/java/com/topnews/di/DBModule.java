package com.topnews.di;

import android.app.Application;

import com.topnews.service.repository.persistence.ArticleDao;
import com.topnews.service.repository.persistence.ArticlesDatabase;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DBModule {

    @Singleton
    @Provides
    static ArticlesDatabase providesArticlesDatabase(Application application){
        return ArticlesDatabase.getInstance(application);
    }

    @Provides
    ArticleDao providesArticleDao(ArticlesDatabase articlesDatabase) {
        return articlesDatabase.articleDao();
    }

}
