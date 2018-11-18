package com.top.movie.rubicon.data.storage;

import com.top.movie.rubicon.data.Search;
import com.top.movie.rubicon.data.TvShow;
import com.top.movie.rubicon.data.TvShowSearch;
import com.top.movie.rubicon.data.storage.remote.content.tvshowsearch.TvShowSearchRemoteDataSource;

import java.util.List;

public class TvShowSearchRepository {

    public static final String TAG = TvShowSearchRepository.class.getSimpleName();

    private static TvShowSearchRepository sInstance = null;

    private final TvShowSearchRemoteDataSource mTvShowSearchRemoteDataSource;

    public TvShowSearchRepository(TvShowSearchRemoteDataSource tvShowSearchRemoteDataSource) {
        mTvShowSearchRemoteDataSource = tvShowSearchRemoteDataSource;
    }

    public static TvShowSearchRepository getInstance(TvShowSearchRemoteDataSource tvShowSearchRemoteDataSource) {
        if (sInstance == null) {
            sInstance = new TvShowSearchRepository(tvShowSearchRemoteDataSource);
        }
        return sInstance;
    }

    public void getTvShowSearch(String word, final GetTvShowSearchCallback callback) {
        mTvShowSearchRemoteDataSource.getTvShowSearch(word, new TvShowSearchRemoteDataSource.GetTvShowSearchCallback() {
            @Override
            public void onSuccess(List<TvShow> tvShows) {
                callback.onSuccess(tvShows);
            }

            @Override
            public void onError() {

            }
        });
    }

    public interface GetTvShowSearchCallback {
        void onSuccess(List<TvShow> tvShow);

        void onError();
    }

}
