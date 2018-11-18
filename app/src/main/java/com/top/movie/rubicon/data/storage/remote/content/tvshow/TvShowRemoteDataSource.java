package com.top.movie.rubicon.data.storage.remote.content.tvshow;

import android.content.Context;

import com.top.movie.rubicon.data.TvShow;
import com.top.movie.rubicon.data.converter.RemoteToLocal;
import com.top.movie.rubicon.data.storage.remote.ServiceGenerator;
import com.top.movie.rubicon.data.storage.remote.response.movieresponse.ShowBaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowRemoteDataSource {

    private static final String TAG = TvShowRemoteDataSource.class.getSimpleName();

    private static TvShowRemoteDataSource sInstance = null;
    private final Context mContext;

    public TvShowRemoteDataSource(Context context){
        mContext = context;
    }

    public static TvShowRemoteDataSource getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new TvShowRemoteDataSource(context);
        }
        return sInstance;
    }

    public void getTvShow(final GetTvShowCallback callback) {
        TvShowService tvShowService = ServiceGenerator.createService(TvShowService.class);

        tvShowService
                .getTvShow("popular","c7720ac64a6580dc890bb503e5f55335","en-US",1)
                .enqueue(new Callback<ShowBaseResponse>() {
                    @Override
                    public void onResponse(Call<ShowBaseResponse> call, Response<ShowBaseResponse> response) {
                        if (response.isSuccessful()) {


                            callback.onSuccess(
                                    RemoteToLocal.tvShowConverter(
                                            response.body().getShowMovieRespons()
                                    )
                            );

                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<ShowBaseResponse> call, Throwable t) {

                    }
                });

    }


    public interface GetTvShowCallback {
        void onSuccess(List<TvShow> tvShows);

        void onError();
    }
}
