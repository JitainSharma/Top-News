package com.topnews.service.repository;

import com.topnews.service.model.NewsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {

    @GET
    Observable<NewsResponse> countryTopHeadlines(@Query("country") String country,
                                                 @Query("apiKey") String apiKey);

}
