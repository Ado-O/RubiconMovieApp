package com.top.movie.rubicon.data.storage.remote.content.description;

import com.top.movie.rubicon.data.storage.remote.response.descriptionresponse.DescriptionBaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DescriptionService {
    /**
     * piece of URL
     */
    @GET("3/tv/{tv_id}")
    Call<DescriptionBaseResponse> getDescription(
            @Path("tv_id")int tvId,
            @Query("api_key")String apiKey,
            @Query("language")String language
    );

    //https://api.themoviedb.org/3/tv/1418?api_key=c7720ac64a6580dc890bb503e5f55335&language=en-US
  //  https://api.themoviedb.org/3/tv/1402?api_key=c7720ac64a6580dc890bb503e5f55335&language=en-US
}
