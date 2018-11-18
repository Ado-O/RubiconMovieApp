package com.top.movie.rubicon;

import android.content.Context;

import com.top.movie.rubicon.data.storage.DescriptionRepository;
import com.top.movie.rubicon.data.storage.MovieRepository;
import com.top.movie.rubicon.data.storage.MovieSearchRepository;
import com.top.movie.rubicon.data.storage.TvShowRepository;
import com.top.movie.rubicon.data.storage.TvShowSearchRepository;
import com.top.movie.rubicon.data.storage.remote.content.description.DescriptionRemoteDataSource;
import com.top.movie.rubicon.data.storage.remote.content.movie.MovieRemoteDataSource;
import com.top.movie.rubicon.data.storage.remote.content.moviesearch.MovieSearchRemoteDataSource;
import com.top.movie.rubicon.data.storage.remote.content.tvshow.TvShowRemoteDataSource;
import com.top.movie.rubicon.data.storage.remote.content.tvshowsearch.TvShowSearchRemoteDataSource;

public class Injection {

    /******************
     *RemoteDataSource
     *****************/
    public static MovieRemoteDataSource provideMovieRemoteDataSource(Context context) {
        return MovieRemoteDataSource.getInstance(context);
    }

    public static TvShowRemoteDataSource provideTvShowRemoteDataSource(Context context) {
        return TvShowRemoteDataSource.getInstance(context);
    }

    public static MovieSearchRemoteDataSource provideSearchRemoteDataSource(Context context) {
        return MovieSearchRemoteDataSource.getInstance(context);
    }

    public static TvShowSearchRemoteDataSource provideTvShowSearchRemoteDataSource(Context context){
        return TvShowSearchRemoteDataSource.getInstance(context);
    }

    public static DescriptionRemoteDataSource provideDescriptionRemoteDataSource(){
        return DescriptionRemoteDataSource.getInstance();
    }

    /************
     *Repository
     ***********/
    public static MovieRepository provideMovieRepository(Context context) {
        return MovieRepository.getInstance(
                provideMovieRemoteDataSource(context)
        );
    }

    public static TvShowRepository provideTvShowRepository(Context context) {
        return TvShowRepository.getInstance(
                provideTvShowRemoteDataSource(context)
        );
    }

    public static MovieSearchRepository provideMovieSearchRepository(Context context) {
        return MovieSearchRepository.getInstance(
                provideSearchRemoteDataSource(context)
        );
    }

    public static TvShowSearchRepository provideTvShowSearchRepository(Context context){
        return TvShowSearchRepository.getInstance(
                provideTvShowSearchRemoteDataSource(context)
        );
    }

    public static DescriptionRepository provideDescriptionRepository(){
        return DescriptionRepository.getInstance(
                provideDescriptionRemoteDataSource()
        );
    }

}
