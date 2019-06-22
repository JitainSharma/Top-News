package com.topnews.viewmodel;

import android.util.Log;

import com.topnews.service.model.Article;
import com.topnews.service.repository.NewsRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class NewsListViewModel extends ViewModel {

    private final NewsRepository mNewsRepository;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    private final MutableLiveData<List<Article>> mDataLive = new MutableLiveData<>();

    @Inject
    public NewsListViewModel(NewsRepository mNewsRepository) {

        this.mNewsRepository = mNewsRepository;

    }

    public LiveData<List<Article>> getDataLive() {
        return mDataLive;
    }

    public void fetchTopNews() {
        compositeDisposable.add(
                mNewsRepository.getTopNews()
                        .observeOn(Schedulers.io())
                        .subscribe(
                                mDataLive::postValue,
                                throwable -> Log.e("fetchTopNews", "", throwable))
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        compositeDisposable.dispose();

    }
}
