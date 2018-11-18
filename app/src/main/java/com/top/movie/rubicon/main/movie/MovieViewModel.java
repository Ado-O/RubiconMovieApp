package com.top.movie.rubicon.main.movie;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.util.Log;

import com.top.movie.rubicon.Injection;
import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.storage.MovieRepository;
import com.top.movie.rubicon.util.SingleLiveEvent;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    public static final String TAG = MovieViewModel.class.getSimpleName();

    private MovieRepository mMovieRepository;
    private Context mContext;

    public final ObservableList<Movie> mMovies = new ObservableArrayList<>();

    public final ObservableBoolean mError = new ObservableBoolean(false);

    private final SingleLiveEvent<Movie> mOpenShopEvent = new SingleLiveEvent<>();


    public MovieViewModel(@NonNull Application application,
                           Context context,
                           MovieRepository movieRepository) {
        super(application);
        mContext = context;
        mMovieRepository = movieRepository;
    }

    /**
     * get all tag
     */
    public void start() {
        if (mMovies.isEmpty()) {
            getMovie();
        }
    }

    private void getMovie() {
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

    public SingleLiveEvent<Movie> getOpenShopEvent() {
        return mOpenShopEvent;
    }
}