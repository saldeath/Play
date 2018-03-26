package com.example.silwan.play.data;

import io.reactivex.Single;

/**
 * Created by Silwan on 25/03/2018.
 */

public interface GithubDataSource<T> {
    Single<T> searchRepo(String value);
}
