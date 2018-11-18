package com.top.movie.rubicon.data.storage.remote.content.tvshowsearch;

import android.content.Context;

import com.top.movie.rubicon.data.Search;
import com.top.movie.rubicon.data.TvShow;
import com.top.movie.rubicon.data.TvShowSearch;
import com.top.movie.rubicon.data.converter.RemoteToLocal;
import com.top.movie.rubicon.data.storage.remote.ServiceGenerator;
import com.top.movie.rubicon.data.storage.remote.response.searchresponse.TvShowSearchBaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowSearchRemoteDataSource {

    private static final String TAG = TvShowSearchRemoteDataSource.class.getSimpleName();

    private static TvShowSearchRemoteDataSource sInstance = null;
    private final Context mContext;

    public TvShowSearchRemoteDataSource(Context context){
        mContext = context;
    }

    public static TvShowSearchRemoteDataSource getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new TvShowSearchRemoteDataSource(context);
        }
        return sInstance;
    }

    public void getTvShowSearch(String word, final GetTvShowSearchCallback callback) {
        TvShowSearchService tvShowSearchService = ServiceGenerator.createService(TvShowSearchService.class);

        tvShowSearchService
                .getSearch("tv", "c7720ac64a6580dc890bb503e5f55335", "en-US", word, 1)
                .enqueue(new Callback<TvShowSearchBaseResponse>() {
                    @Override
                    public void onResponse(Call<TvShowSearchBaseResponse> call, Response<TvShowSearchBaseResponse> response) {
                        if (response.isSuccessful()) {



                            callback.onSuccess(
                                    RemoteToLocal.tvShowSearchConverter(
                                            response.body().getTvShowSearchResponses()
                                    )
                            );

                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<TvShowSearchBaseResponse> call, Throwable t) {

                    }
                });

    }

    public interface GetTvShowSearchCallback {
        void onSuccess(List<TvShow> tvShows);

        void onError();
    }
}
