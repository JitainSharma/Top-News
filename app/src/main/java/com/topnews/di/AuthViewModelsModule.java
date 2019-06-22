package com.topnews.di;

import com.topnews.viewmodel.NewsListViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsListViewModel.class)
    public abstract ViewModel bindAuthViewModel(NewsListViewModel viewModel);
}