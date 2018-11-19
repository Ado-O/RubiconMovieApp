package com.top.movie.rubicon.data.storage.remote.content.show;

import com.top.movie.rubicon.data.storage.remote.response.response.ShowBaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ShowService {

    /**************
     * piece of URL
     ***************/
    @GET("3/tv/{category}")
    Call<ShowBaseResponse> getTvShow(
            @Path("category")String category,
            @Query("api_key")String apiKey,
            @Query("language")String language,
            @Query("page")int page
    );
}
