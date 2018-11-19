package com.top.movie.rubicon;

import android.content.Context;

import com.top.movie.rubicon.data.storage.MovieRepository;
import com.top.movie.rubicon.data.storage.MovieSearchRepository;
import com.top.movie.rubicon.data.storage.ShowRepository;
import com.top.movie.rubicon.data.storage.ShowSearchRepository;
import com.top.movie.rubicon.data.storage.remote.content.movie.MovieRemoteDataSource;
import com.top.movie.rubicon.data.storage.remote.content.moviesearch.MovieSearchRemoteDataSource;
import com.top.movie.rubicon.data.storage.remote.content.show.ShowRemoteDataSource;
import com.top.movie.rubicon.data.storage.remote.content.showsearch.ShowSearchRemoteDataSource;

public class Injection {

    /******************
     *RemoteDataSource
     *****************/
    public static MovieRemoteDataSource provideMovieRemoteDataSource(Context context) {
        return MovieRemoteDataSource.getInstance(context);
    }

    public static ShowRemoteDataSource provideShowRemoteDataSource(Context context) {
        return ShowRemoteDataSource.getInstance(context);
    }

    public static MovieSearchRemoteDataSource provideSearchRemoteDataSource(Context context) {
        return MovieSearchRemoteDataSource.getInstance(context);
    }

    public static ShowSearchRemoteDataSource provideShowSearchRemoteDataSource(Context context){
        return ShowSearchRemoteDataSource.getInstance(context);
    }

    /************
     *Repository
     ***********/
    public static MovieRepository provideMovieRepository(Context context) {
        return MovieRepository.getInstance(
                provideMovieRemoteDataSource(context)
        );
    }

    public static ShowRepository provideShowRepository(Context context) {
        return ShowRepository.getInstance(
                provideShowRemoteDataSource(context)
        );
    }

    public static MovieSearchRepository provideMovieSearchRepository(Context context) {
        return MovieSearchRepository.getInstance(
                provideSearchRemoteDataSource(context)
        );
    }

    public static ShowSearchRepository provideShowSearchRepository(Context context){
        return ShowSearchRepository.getInstance(
                provideShowSearchRemoteDataSource(context)
        );
    }

}
