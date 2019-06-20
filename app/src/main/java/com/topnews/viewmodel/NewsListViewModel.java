package com.topnews.viewmodel;

import com.topnews.MyApp;
import com.topnews.service.model.Article;
import com.topnews.service.repository.NewsRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class NewsListViewModel extends ViewModel {

    @Inject
    NewsRepository mNewsRepository;

    NewsListViewModel() {

        MyApp.getMyComponent().inject(this);

    }

    public Observable<List<Article>> getTopNews() {
        return mNewsRepository.getTopNews();
    }

}
