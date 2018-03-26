package com.example.silwan.play.di.modules;

import android.content.Context;

import com.example.silwan.play.Play;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Silwan on 20/03/2018.
 */

@Module
public class AppModule {
    @Provides
    Context provideContext(Play application){
        return application.getApplicationContext();
    }
}
