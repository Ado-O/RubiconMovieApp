package com.top.movie.rubicon.main.moviesearch;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.top.movie.rubicon.Injection;
import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.storage.MovieRepository;
import com.top.movie.rubicon.data.storage.MovieSearchRepository;
import com.top.movie.rubicon.util.SingleLiveEvent;

import java.util.List;

public class MovieSearchViewModel extends AndroidViewModel {

    public static final String TAG = MovieSearchViewModel.class.getSimpleName();

    private Context mContext;

    public final ObservableList<Movie> mMovies = new ObservableArrayList<>();

    public final ObservableBoolean mError = new ObservableBoolean(false);

    private final SingleLiveEvent<Movie> mOpenShopEvent = new SingleLiveEvent<>();

    public MovieSearchViewModel(@NonNull Application application,
                                Context context) {
        super(application);
        mContext = context;
    }

    /********
     * exit func
     *******/
    public void startMovie(String word) {
        if (mMovies.isEmpty()) {
            getMovie();
        } else {
            getMovieSearch(word);
        }
    }

    /****************
     * get all movie
     ***************/
    public void getMovie() {
        Injection.provideMovieRepository(mContext).getMovie(new MovieRepository.GetMovieCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                mMovies.clear();
                mMovies.addAll(movies);
                mError.set(mMovies.isEmpty());
            }

            @Override
            public void onError() {

            }
        });
    }

    /***********************************
     * add word and get movie from search
     ************************************/
    public void getMovieSearch(String word) {
        Injection.provideMovieSearchRepository(mContext).getSearch(word, new MovieSearchRepository.GetSearchCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                mMovies.clear();
                mMovies.addAll(movies);
                mError.set(mMovies.isEmpty());
            }

            @Override
            public void onError() {

            }
        });
    }

    public SingleLiveEvent<Movie> getOpenShopEvent() {
        return mOpenShopEvent;
    }
}