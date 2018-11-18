package com.top.movie.rubicon.data.storage.remote.content.movie;

import com.top.movie.rubicon.data.storage.remote.response.movieresponse.MovieBaseResponse;
import com.top.movie.rubicon.data.storage.remote.response.movieresponse.ShowBaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {
    /**
     * piece of URL
     */
        @GET("3/movie/{category}")
        Call<MovieBaseResponse> getMovies(
                @Path("category")String category,
                @Query("api_key")String apiKey,
                @Query("language")String language,
                @Query("page")int page
        );

  //  https://api.themoviedb.org/3/movie/popular?api_key=c7720ac64a6580dc890bb503e5f55335&language=en-US&page=1
    }