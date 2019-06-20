package com.topnews.di;

import com.topnews.service.repository.persistence.ArticleDao;
import com.topnews.service.repository.persistence.ArticlesDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class DBModule {

    private ArticlesDatabase articlesDatabase;

    public DBModule(ArticlesDatabase articlesDatabase) {
        this.articlesDatabase = articlesDatabase;
    }

    @Provides
    ArticleDao providesArticleDao() {
        return articlesDatabase.articleDao();
    }

}
