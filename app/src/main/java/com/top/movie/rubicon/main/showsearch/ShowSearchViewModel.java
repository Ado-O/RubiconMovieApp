package com.top.movie.rubicon.main.showsearch;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.top.movie.rubicon.Injection;
import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.TvShow;
import com.top.movie.rubicon.data.storage.MovieRepository;
import com.top.movie.rubicon.data.storage.MovieSearchRepository;
import com.top.movie.rubicon.data.storage.TvShowRepository;
import com.top.movie.rubicon.data.storage.TvShowSearchRepository;
import com.top.movie.rubicon.main.moviesearch.MovieSearchViewModel;
import com.top.movie.rubicon.util.SingleLiveEvent;

import java.util.List;

public class ShowSearchViewModel extends AndroidViewModel {

    public static final String TAG = MovieSearchViewModel.class.getSimpleName();

    private Context mContext;

    public final ObservableList<TvShow> mTvShows = new ObservableArrayList<>();

    public final ObservableBoolean mError = new ObservableBoolean(false);

    private final SingleLiveEvent<TvShow> mOpenShopEvent = new SingleLiveEvent<>();

    public ShowSearchViewModel(@NonNull Application application,
                                Context context) {
        super(application);
        mContext = context;
    }

    /*********
     * tvShow
     ********/
    public void startShow(String word) {
        if (mTvShows.isEmpty()) {
            getShow();
        } else {
            getShowSearch(word);
        }
    }

    public void getShow() {
        Injection.provideTvShowRepository(mContext).getTvShow(new TvShowRepository.GetTvShowCallback() {
            @Override
            public void onSuccess(List<TvShow> tvShows) {
                mTvShows.clear();
                mTvShows.addAll(tvShows);
                mError.set(mTvShows.isEmpty());
            }

            @Override
            public void onError() {

            }
        });
    }

    public void getShowSearch(String word) {
        Injection.provideTvShowSearchRepository(mContext).getTvShowSearch(word, new TvShowSearchRepository.GetTvShowSearchCallback() {
            @Override
            public void onSuccess(List<TvShow> tvShow) {
                mTvShows.clear();
                mTvShows.addAll(tvShow);
                mError.set(mTvShows.isEmpty());
            }

            @Override
            public void onError() {

            }
        });
    }

    public SingleLiveEvent<TvShow> getOpenShopEvent() {
        return mOpenShopEvent;
    }
}