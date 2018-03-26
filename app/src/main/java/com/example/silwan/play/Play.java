package com.example.silwan.play;


import com.example.silwan.play.di.components.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import timber.log.Timber;

/**
 * Created by Silwan on 20/03/2018.
 */

public class Play extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
