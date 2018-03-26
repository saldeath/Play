package com.example.silwan.play.di.modules;

import com.example.silwan.play.data.GithubDataSource;
import com.example.silwan.play.data.remote.GithubApi;
import com.example.silwan.play.data.GithubRepository;
import com.example.silwan.play.di.scopes.ApplicationScope;
import com.example.silwan.play.model.ApiResponse;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Silwan on 25/03/2018.
 */

@Module(includes = NetworkModule.class)
public class ApiModule {
    @ApplicationScope
    @Provides
    static GithubApi randomUserApi(Retrofit retrofit){
        return retrofit.create(GithubApi.class);
    }

    @ApplicationScope
    @Provides
    static GithubDataSource<ApiResponse> randomUserRepository(GithubApi githubApi){
        return new GithubRepository(githubApi);
    }
}
