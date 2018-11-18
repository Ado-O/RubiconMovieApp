package com.top.movie.rubicon.data.storage;

import com.top.movie.rubicon.data.TvShow;
import com.top.movie.rubicon.data.storage.remote.content.tvshow.TvShowRemoteDataSource;

import java.util.List;

public class TvShowRepository {

    public static final String TAG = TvShowRepository.class.getSimpleName();

    private static TvShowRepository sInstance = null;

    private final TvShowRemoteDataSource mTvShowRemoteDataSource;

    public TvShowRepository(TvShowRemoteDataSource tvShowRemoteDataSource) {
        mTvShowRemoteDataSource = tvShowRemoteDataSource;
    }

    public static TvShowRepository getInstance(TvShowRemoteDataSource tvShowRemoteDataSource) {
        if (sInstance == null) {
            sInstance = new TvShowRepository(tvShowRemoteDataSource);
        }
        return sInstance;
    }

    public void getTvShow(final GetTvShowCallback callback) {
       mTvShowRemoteDataSource.getTvShow(new TvShowRemoteDataSource.GetTvShowCallback() {
           @Override
           public void onSuccess(List<TvShow> tvShows) {
               callback.onSuccess(tvShows);

           }

           @Override
           public void onError() {

           }
       });


    }


    public interface GetTvShowCallback {
        void onSuccess(List<TvShow> tvShows);

        void onError();
    }


}
