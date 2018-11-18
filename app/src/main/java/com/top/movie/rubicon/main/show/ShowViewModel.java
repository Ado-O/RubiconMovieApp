package com.top.movie.rubicon.main.show;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.top.movie.rubicon.Injection;
import com.top.movie.rubicon.data.TvShow;
import com.top.movie.rubicon.data.storage.TvShowRepository;
import com.top.movie.rubicon.util.SingleLiveEvent;

import java.util.List;

public class ShowViewModel extends AndroidViewModel {

    private TvShowRepository mTvShowRepository;
    private Context mContext;

    public final ObservableList<TvShow> mTvShows = new ObservableArrayList<>();

    public final ObservableBoolean mError = new ObservableBoolean(false);

    private final SingleLiveEvent<TvShow> mOpenShopEvent = new SingleLiveEvent<>();

    public ShowViewModel(@NonNull Application application,
                         Context context,
                         TvShowRepository tvShowRepository) {
        super(application);
        mContext = context;
        mTvShowRepository = tvShowRepository;
    }

    /**
     * get all tag
     */
    public void start() {
        if (mTvShows.isEmpty()) {
            getMovie();
        }
    }

    private void getMovie() {
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



    public SingleLiveEvent<TvShow> getOpenShopEvent() {
        return mOpenShopEvent;
    }
}