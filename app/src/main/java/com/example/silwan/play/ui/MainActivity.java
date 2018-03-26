package com.example.silwan.play.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.silwan.play.R;
import com.example.silwan.play.data.GithubRepository;
import com.example.silwan.play.databinding.ActivityMainBinding;
import com.example.silwan.play.model.ApiResponse;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    GithubRepository githubRepository;

    @Inject
    MainActivityViewModelFactory mainActivityViewModelFactory;

    @Inject
    MainActivityViewModel mainActivityViewModel;

    private ActivityMainBinding mActivityMainBinding;

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainActivityViewModel = ViewModelProviders.of(this, mainActivityViewModelFactory).get(MainActivityViewModel.class);

        mainActivityViewModel.getResponse().observe(this, this::process);

        initSearch();
    }

    private void initSearch() {
       disposable = RxTextView.textChanges(mActivityMainBinding.search)
                .debounce(300, TimeUnit.MILLISECONDS)
                .filter(charSequence -> charSequence.length() > 1)
                .map(CharSequence::toString)
                .distinctUntilChanged()
                .switchMap(query -> mainActivityViewModel.getSearch(query))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> mainActivityViewModel.getResponse().setValue(s),
                        error -> Timber.d("Error: " + error));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }

    private void process(ApiResponse apiResponse) {
        mActivityMainBinding.setResponse(apiResponse);
    }
}
