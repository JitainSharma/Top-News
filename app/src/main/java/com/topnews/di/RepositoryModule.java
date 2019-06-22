package com.topnews.di;

import com.topnews.service.repository.NewsRepository;
import com.topnews.service.repository.NewsService;
import com.topnews.service.repository.persistence.ArticleDao;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    public NewsRepository providesNewsRepository(ArticleDao mArticleDao, NewsService mNewsService) {
        return new NewsRepository(mArticleDao, mNewsService);
    }

}
