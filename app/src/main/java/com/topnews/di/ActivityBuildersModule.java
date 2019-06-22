package com.topnews.di;

import com.topnews.view.ui.MainActivity;
import com.topnews.view.ui.NewsListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector()
    abstract MainActivity contributeMainActivity();

}