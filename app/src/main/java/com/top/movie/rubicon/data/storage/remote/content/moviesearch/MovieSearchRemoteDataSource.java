package com.top.movie.rubicon.data.storage.remote.content.moviesearch;

import android.content.Context;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.converter.RemoteToLocal;
import com.top.movie.rubicon.data.storage.remote.ServiceGenerator;
import com.top.movie.rubicon.data.storage.remote.response.searchresponse.SearchBaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieSearchRemoteDataSource {

    private static final String TAG = MovieSearchRemoteDataSource.class.getSimpleName();

    private static MovieSearchRemoteDataSource sInstance = null;
    private final Context mContext;

    public MovieSearchRemoteDataSource(Context context) {
        mContext = context;
    }

    public static MovieSearchRemoteDataSource getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new MovieSearchRemoteDataSource(context);
        }
        return sInstance;
    }

    /***************************************
     * Getting the content from the content url
     *
     *******************************************/
    public void getSearch(String word, final GetSearchallback callback) {
        MovieSearchService movieSearchService = ServiceGenerator.createService(MovieSearchService.class);

        movieSearchService
                .getSearch("movie", "c7720ac64a6580dc890bb503e5f55335", "en-US", word, 1)
                .enqueue(new Callback<SearchBaseResponse>() {
                    @Override
                    public void onResponse(Call<SearchBaseResponse> call, Response<SearchBaseResponse> response) {
                        if (response.isSuccessful()) {


                            callback.onSuccess(
                                    RemoteToLocal.searchConverter(
                                            response.body().getSearchResponses()
                                    )
                            );

                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchBaseResponse> call, Throwable t) {

                    }
                });
    }

    public interface GetSearchallback {
        void onSuccess(List<Movie> movies);

        void onError();
    }
}
