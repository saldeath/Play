package com.example.silwan.play.ui;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.silwan.play.data.GithubDataSource;
import com.example.silwan.play.model.ApiResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Silwan on 23/03/2018.
 */

public class MainActivityViewModel extends ViewModel {

    private GithubDataSource<ApiResponse> mGithubRepository;
    private MutableLiveData<ApiResponse> response = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public MainActivityViewModel(GithubDataSource<ApiResponse> githubRepository) {
        this.mGithubRepository = githubRepository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

    @Deprecated
    public void getRandomUser(String search){
        disposable.add(mGithubRepository.searchRepo(search)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> response.setValue(result),
                        throwable -> Timber.d("oops")
                ));
    }

    public Observable<ApiResponse> getSearch(String search){
        return mGithubRepository.searchRepo(search).toObservable();
    }

    public MutableLiveData<ApiResponse> getResponse() {
        return response;
    }
}
