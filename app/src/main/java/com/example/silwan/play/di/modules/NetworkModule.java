package com.example.silwan.play.di.modules;

import com.example.silwan.play.di.scopes.ApplicationScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Silwan on 21/03/2018.
 */

@Module
public class NetworkModule {
    public static final String API_URL = "https://api.github.com/";

    @ApplicationScope
    @Provides
    static Retrofit retrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory){
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @ApplicationScope
    @Provides
    static Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @ApplicationScope
    @Provides
    static GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }

    @ApplicationScope
    @Provides
    static OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor){
        return new OkHttpClient().newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @ApplicationScope
    @Provides
    static HttpLoggingInterceptor httpLoggingInterceptor(){
        return new HttpLoggingInterceptor(message -> Timber.d(message))
                .setLevel(HttpLoggingInterceptor.Level.HEADERS);
    }
}
