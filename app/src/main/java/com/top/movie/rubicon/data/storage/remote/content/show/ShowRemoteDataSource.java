package com.top.movie.rubicon.data.storage.remote.content.show;

import android.content.Context;

import com.top.movie.rubicon.data.Show;
import com.top.movie.rubicon.data.converter.RemoteToLocal;
import com.top.movie.rubicon.data.storage.remote.ServiceGenerator;
import com.top.movie.rubicon.data.storage.remote.response.response.ShowBaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowRemoteDataSource {

    private static final String TAG = ShowRemoteDataSource.class.getSimpleName();

    private static ShowRemoteDataSource sInstance = null;
    private final Context mContext;

    public ShowRemoteDataSource(Context context) {
        mContext = context;
    }

    public static ShowRemoteDataSource getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new ShowRemoteDataSource(context);
        }
        return sInstance;
    }

    /***************************************
     * Getting the content from the content url
     *
     *******************************************/
    public void getTvShow(final GetShowCallback callback) {
        ShowService showService = ServiceGenerator.createService(ShowService.class);

        showService
                .getTvShow("popular", "c7720ac64a6580dc890bb503e5f55335", "en-US", 1)
                .enqueue(new Callback<ShowBaseResponse>() {
                    @Override
                    public void onResponse(Call<ShowBaseResponse> call, Response<ShowBaseResponse> response) {
                        if (response.isSuccessful()) {


                            callback.onSuccess(
                                    RemoteToLocal.showConverter(
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

    public interface GetShowCallback {
        void onSuccess(List<Show> shows);

        void onError();
    }
}
