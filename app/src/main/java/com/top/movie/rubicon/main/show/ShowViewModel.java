package com.top.movie.rubicon.main.show;

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
import com.top.movie.rubicon.util.SingleLiveEvent;

import java.util.List;

public class ShowViewModel extends AndroidViewModel {

    private Context mContext;

    public final ObservableList<Show> mShows = new ObservableArrayList<>();

    public final ObservableBoolean mError = new ObservableBoolean(false);

    private final SingleLiveEvent<Show> mOpenShopEvent = new SingleLiveEvent<>();

    public ShowViewModel(@NonNull Application application,
                         Context context) {
        super(application);
        mContext = context;
    }

    /*************
     * get all tvShow
     **************/
    public void start() {
        if (mShows.isEmpty()) {
            getMovie();
        }
    }

    private void getMovie() {
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

    public SingleLiveEvent<Show> getOpenShopEvent() {
        return mOpenShopEvent;
    }
}