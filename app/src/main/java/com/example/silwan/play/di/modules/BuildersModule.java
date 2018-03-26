package com.example.silwan.play.di.modules;

import com.example.silwan.play.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Silwan on 20/03/2018.
 */
@Module
public abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
