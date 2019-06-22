package com.topnews.di;

import android.app.Application;

import com.topnews.MyApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                FragmentBuilderModule.class,
                ContextModule.class,
                DBModule.class,
                NetModule.class,
                RepositoryModule.class,
                ViewModelFactoryModule.class}
)
public interface AppComponent extends AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
