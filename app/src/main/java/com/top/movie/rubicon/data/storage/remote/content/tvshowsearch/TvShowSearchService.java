package com.top.movie.rubicon.data.storage.remote.content.tvshowsearch;

import com.top.movie.rubicon.data.storage.remote.response.searchresponse.TvShowSearchBaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TvShowSearchService {
    /**
     * piece of URL
     */
    @GET("3/search/{category}")
    Call<TvShowSearchBaseResponse> getSearch(
            @Path("category")String category,
            @Query("api_key")String apiKey,
            @Query("language")String language,
            @Query("query")String query,
            @Query("page")int page
    );

  //https://api.themoviedb.org/3/search/tv?api_key=c7720ac64a6580dc890bb503e5f55335&language=en-US&query=a&page=1}
}