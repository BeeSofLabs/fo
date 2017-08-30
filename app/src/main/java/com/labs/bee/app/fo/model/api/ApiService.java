package com.labs.bee.app.fo.model.api;

import android.database.Observable;

import com.labs.bee.app.fo.model.api.response.MultipleResponse;
import com.labs.bee.app.fo.model.pojo.Article;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by arysuryawan on 8/18/17.
 */
public interface ApiService {


    @Headers({
            "Cache-Control: no-cache",
            "Cache-Control: no-store",
            "Accept: application/json",
            "Content-Type: application/json"})
    @GET("sources")
    Call<MultipleResponse> callApiSources(@Query("language") String language);

    @Headers({
            "Cache-Control: no-cache",
            "Cache-Control: no-store",
            "Accept: application/json",
            "Content-Type: application/json"})
    @GET("articles")
    Call<MultipleResponse> callApiArticles(@Query("source") String sourceId, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);

    @GET("articles}")
    Observable<Article> getArticles(@Query("source") String sourceId, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);
}
