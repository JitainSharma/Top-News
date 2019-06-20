package com.topnews.di;

import com.topnews.viewmodel.NewsListViewModel;

import dagger.Component;

@Component(modules={ContextModule.class, DBModule.class, NetModule.class, RepositoryModule.class})
public interface MyComponent {

    void inject(NewsListViewModel newsListViewModel);
    //void inject(NewsRepository newsRepository);
    //void inject(NewsService newsService);

}
