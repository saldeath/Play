package com.example.silwan.play.di.components;

import com.example.silwan.play.Play;
import com.example.silwan.play.di.modules.ApiModule;
import com.example.silwan.play.di.modules.AppModule;
import com.example.silwan.play.di.modules.BuildersModule;
import com.example.silwan.play.di.scopes.ApplicationScope;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Silwan on 20/03/2018.
 */

@ApplicationScope
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, BuildersModule.class, ApiModule.class})
public interface AppComponent extends AndroidInjector<Play> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<Play>{}
}
