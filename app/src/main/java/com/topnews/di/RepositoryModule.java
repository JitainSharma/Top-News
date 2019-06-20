package com.topnews.di;

import com.topnews.service.repository.NewsRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    NewsRepository providesNewsRepository() {
        return new NewsRepository();
    }

}
