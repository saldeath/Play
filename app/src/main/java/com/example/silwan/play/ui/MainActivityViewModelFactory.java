package com.example.silwan.play.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.silwan.play.data.GithubDataSource;
import com.example.silwan.play.model.ApiResponse;

import javax.inject.Inject;

/**
 * Created by Silwan on 23/03/2018.
 */

public class MainActivityViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private GithubDataSource<ApiResponse> mGithubRepository;

    @Inject
    public MainActivityViewModelFactory(GithubDataSource<ApiResponse> githubRepository) {
        this.mGithubRepository = githubRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainActivityViewModel(mGithubRepository);
    }
}
