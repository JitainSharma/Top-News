package com.topnews;

import android.app.Application;

import com.topnews.di.ContextModule;
import com.topnews.di.DBModule;
import com.topnews.di.DaggerMyComponent;
import com.topnews.di.MyComponent;
import com.topnews.di.NetModule;
import com.topnews.di.RepositoryModule;
import com.topnews.service.repository.persistence.ArticlesDatabase;

public class MyApp extends Application {

    private static MyComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerMyComponent.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .dBModule(new DBModule(getDatabase()))
                .netModule(new NetModule())
                .repositoryModule(new RepositoryModule())
                .build();

    }

    public static MyComponent getMyComponent() {
        return component;
    }

    public ArticlesDatabase getDatabase() {
        return ArticlesDatabase.getInstance(this);
    }

}
