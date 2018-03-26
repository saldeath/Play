package com.example.silwan.play.data.remote;

import com.example.silwan.play.model.ApiResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Silwan on 21/03/2018.
 */

public interface GithubApi {
    @GET("search/repositories")
    Single<ApiResponse> searchRepos(@Query("q") String query);
}
