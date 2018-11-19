package com.top.movie.rubicon.main.showsearch;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.top.movie.rubicon.Injection;
import com.top.movie.rubicon.data.Show;
import com.top.movie.rubicon.data.storage.ShowRepository;
import com.top.movie.rubicon.data.storage.ShowSearchRepository;
import com.top.movie.rubicon.main.moviesearch.MovieSearchViewModel;
import com.top.movie.rubicon.util.SingleLiveEvent;

import java.util.List;

public class ShowSearchViewModel extends AndroidViewModel {

    public static final String TAG = MovieSearchViewModel.class.getSimpleName();

    private Context mContext;

    public final ObservableList<Show> mShows = new ObservableArrayList<>();

    public final ObservableBoolean mError = new ObservableBoolean(false);

    private final SingleLiveEvent<Show> mOpenShopEvent = new SingleLiveEvent<>();

    public ShowSearchViewModel(@NonNull Application application,
                                Context context) {
        super(application);
        mContext = context;
    }

    /*********
     * tvShow
     ********/
    public void startShow(String word) {
        if (mShows.isEmpty()) {
            getShow();
        } else {
            getShowSearch(word);
        }
    }

    /****************
     * get all tvShow
     ***************/
    public void getShow() {
        Injection.provideShowRepository(mContext).getShow(new ShowRepository.GetShowCallback() {
            @Override
            public void onSuccess(List<Show> shows) {
                mShows.clear();
                mShows.addAll(shows);
                mError.set(mShows.isEmpty());
            }

            @Override
            public void onError() {

            }
        });
    }

    /***********************************
     * add word and get tvShow from search
     ************************************/
    public void getShowSearch(String word) {
        Injection.provideShowSearchRepository(mContext).getShowSearch(word, new ShowSearchRepository.GetShowSearchCallback() {
            @Override
            public void onSuccess(List<Show> show) {
                mShows.clear();
                mShows.addAll(show);
                mError.set(mShows.isEmpty());
            }

            @Override
            public void onError() {

            }
        });
    }

    public SingleLiveEvent<Show> getOpenShopEvent() {
        return mOpenShopEvent;
    }
}