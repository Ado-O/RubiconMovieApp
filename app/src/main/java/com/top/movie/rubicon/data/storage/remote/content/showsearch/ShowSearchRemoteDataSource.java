package com.top.movie.rubicon.data.storage.remote.content.showsearch;

import android.content.Context;

import com.top.movie.rubicon.data.Show;
import com.top.movie.rubicon.data.converter.RemoteToLocal;
import com.top.movie.rubicon.data.storage.remote.ServiceGenerator;
import com.top.movie.rubicon.data.storage.remote.response.searchresponse.ShowSearchBaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowSearchRemoteDataSource {

    private static final String TAG = ShowSearchRemoteDataSource.class.getSimpleName();

    private static ShowSearchRemoteDataSource sInstance = null;
    private final Context mContext;

    public ShowSearchRemoteDataSource(Context context){
        mContext = context;
    }

    public static ShowSearchRemoteDataSource getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new ShowSearchRemoteDataSource(context);
        }
        return sInstance;
    }

    public void getTvShowSearch(String word, final GetShowSearchCallback callback) {
        ShowSearchService showSearchService = ServiceGenerator.createService(ShowSearchService.class);

        showSearchService
                .getSearch("tv", "c7720ac64a6580dc890bb503e5f55335", "en-US", word, 1)
                .enqueue(new Callback<ShowSearchBaseResponse>() {
                    @Override
                    public void onResponse(Call<ShowSearchBaseResponse> call, Response<ShowSearchBaseResponse> response) {
                        if (response.isSuccessful()) {



                            callback.onSuccess(
                                    RemoteToLocal.showSearchConverter(
                                            response.body().getShowSearchRespons()
                                    )
                            );

                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<ShowSearchBaseResponse> call, Throwable t) {

                    }
                });

    }

    public interface GetShowSearchCallback {
        void onSuccess(List<Show> shows);

        void onError();
    }
}
