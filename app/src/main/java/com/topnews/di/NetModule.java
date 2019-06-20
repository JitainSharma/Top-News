package com.topnews.di;

import com.topnews.BuildConfig;
import com.topnews.service.repository.NewsService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    @Provides
    @Singleton
    NewsService providesNewsService() {

        OkHttpClient.Builder httpClient =
                new OkHttpClient.Builder()
                        //.addInterceptor(logging)
                        .connectTimeout(1, TimeUnit.MINUTES)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(15, TimeUnit.SECONDS);


        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(BuildConfig.BASE_API)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();

        return retrofit.create(NewsService.class);

    }

}
