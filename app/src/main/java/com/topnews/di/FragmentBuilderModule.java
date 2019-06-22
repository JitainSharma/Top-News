package com.topnews.di;

import com.topnews.view.ui.NewsListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {
    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class})
    abstract NewsListFragment contributeNewsListFragment();
}
