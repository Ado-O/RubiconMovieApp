package com.top.movie.rubicon.data.storage.remote.content.moviesearch;

import com.top.movie.rubicon.data.storage.remote.response.searchresponse.SearchBaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieSearchService {
    /***************
     * piece of URL
     **************/
    @GET("3/search/{category}")
    Call<SearchBaseResponse> getSearch(
            @Path("category")String category,
            @Query("api_key")String apiKey,
            @Query("language")String language,
            @Query("query")String query,
            @Query("page")int page
    );
    // https://api.themoviedb.org/3/search/movie?api_key=c7720ac64a6580dc890bb503e5f55335&language=en-US&query=a&page=1
}

