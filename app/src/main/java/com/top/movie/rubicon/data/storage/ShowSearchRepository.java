package com.top.movie.rubicon.data.storage;

import com.top.movie.rubicon.data.Show;
import com.top.movie.rubicon.data.storage.remote.content.showsearch.ShowSearchRemoteDataSource;

import java.util.List;

public class ShowSearchRepository {

    public static final String TAG = ShowSearchRepository.class.getSimpleName();

    private static ShowSearchRepository sInstance = null;

    private final ShowSearchRemoteDataSource mShowSearchRemoteDataSource;

    public ShowSearchRepository(ShowSearchRemoteDataSource showSearchRemoteDataSource) {
        mShowSearchRemoteDataSource = showSearchRemoteDataSource;
    }

    public static ShowSearchRepository getInstance(ShowSearchRemoteDataSource showSearchRemoteDataSource) {
        if (sInstance == null) {
            sInstance = new ShowSearchRepository(showSearchRemoteDataSource);
        }
        return sInstance;
    }

    public void getShowSearch(String word, final GetShowSearchCallback callback) {
        mShowSearchRemoteDataSource.getTvShowSearch(word, new ShowSearchRemoteDataSource.GetShowSearchCallback() {
            @Override
            public void onSuccess(List<Show> shows) {
                callback.onSuccess(shows);
            }

            @Override
            public void onError() {

            }
        });
    }

    public interface GetShowSearchCallback {
        void onSuccess(List<Show> show);

        void onError();
    }

}
