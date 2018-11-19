package com.top.movie.rubicon.data.storage;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.storage.remote.content.moviesearch.MovieSearchRemoteDataSource;

import java.util.List;

public class MovieSearchRepository {

    public static final String TAG = MovieSearchRepository.class.getSimpleName();

    private static MovieSearchRepository sInstance = null;

    private final MovieSearchRemoteDataSource mMovieSearchRemoteDataSource;

    public MovieSearchRepository(MovieSearchRemoteDataSource movieSearchRemoteDataSource) {
        mMovieSearchRemoteDataSource = movieSearchRemoteDataSource;
    }

    public static MovieSearchRepository getInstance(MovieSearchRemoteDataSource movieSearchRemoteDataSource) {
        if (sInstance == null) {
            sInstance = new MovieSearchRepository(movieSearchRemoteDataSource);
        }
        return sInstance;
    }


    public void getSearch(String word, final GetSearchCallback callback) {
        mMovieSearchRemoteDataSource.getSearch(word, new MovieSearchRemoteDataSource.GetSearchallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                callback.onSuccess(movies);
            }

            @Override
            public void onError() {

            }
        });
    }


    public interface GetSearchCallback {
        void onSuccess(List<Movie> movies);

        void onError();
    }

}
