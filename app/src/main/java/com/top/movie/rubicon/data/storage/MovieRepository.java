package com.top.movie.rubicon.data.storage;

import android.util.Log;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.storage.remote.content.movie.MovieRemoteDataSource;

import java.util.List;

public class MovieRepository {

    public static final String TAG = MovieRepository.class.getSimpleName();

    private static MovieRepository sInstance = null;

    private final MovieRemoteDataSource mMovieRemoteDataSource;

    public MovieRepository(MovieRemoteDataSource movieRemoteDataSource) {
        mMovieRemoteDataSource = movieRemoteDataSource;
    }

    public static MovieRepository getInstance(MovieRemoteDataSource movieRemoteDataSource) {
        if (sInstance == null) {
            sInstance = new MovieRepository(movieRemoteDataSource);
        }
        return sInstance;
    }

    public void getMovie(final GetMovieCallback callback) {
        mMovieRemoteDataSource.getMovie(new MovieRemoteDataSource.GetMovieCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                callback.onSuccess(movies);
            }

            @Override
            public void onError() {

            }
        });


    }

    public interface GetMovieCallback {
        void onSuccess(List<Movie> movies);

        void onError();
    }

}
