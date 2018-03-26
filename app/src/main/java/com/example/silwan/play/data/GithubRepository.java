package com.example.silwan.play.data;

import com.example.silwan.play.data.remote.GithubApi;
import com.example.silwan.play.model.ApiResponse;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Silwan on 21/03/2018.
 */

public class GithubRepository implements GithubDataSource<ApiResponse>{

    private GithubApi githubApi;

    @Inject
    public GithubRepository(GithubApi githubApi) {
        this.githubApi = githubApi;
    }

    @Override
    public Single<ApiResponse> searchRepo(String value) {
        return githubApi.searchRepos(value);
    }
}
