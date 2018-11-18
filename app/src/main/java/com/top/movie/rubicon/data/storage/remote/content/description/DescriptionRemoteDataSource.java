package com.top.movie.rubicon.data.storage.remote.content.description;

import android.util.Log;

import com.top.movie.rubicon.data.Description;
import com.top.movie.rubicon.data.converter.RemoteToLocal;
import com.top.movie.rubicon.data.storage.remote.ServiceGenerator;
import com.top.movie.rubicon.data.storage.remote.response.descriptionresponse.DescriptionBaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescriptionRemoteDataSource {

    private static final String TAG = DescriptionRemoteDataSource.class.getSimpleName();

    private static DescriptionRemoteDataSource sInstance = null;

    public static DescriptionRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new DescriptionRemoteDataSource();
        }
        return sInstance;
    }

    public void getDescription(int id, final GetDescriptionCallback callback) {
        DescriptionService descriptionService = ServiceGenerator.createService(DescriptionService.class);

        descriptionService
                .getDescription(id, "c7720ac64a6580dc890bb503e5f55335", "en-US")
                .enqueue(new Callback<DescriptionBaseResponse>() {
                    @Override
                    public void onResponse(Call<DescriptionBaseResponse> call, Response<DescriptionBaseResponse> response) {

                        Log.e(TAG, "desc: "+response.body());
//                        if (response.isSuccessful()) {
//
//                            callback.onSuccess(
//                                    RemoteToLocal.descriptionConverter(
//                                            response.body()
//                                    )
//                            );
//
//                        } else {
//                            callback.onError();
//                        }
                    }

                    @Override
                    public void onFailure(Call<DescriptionBaseResponse> call, Throwable t) {

                    }
                });
    }

    public interface GetDescriptionCallback {
        void onSuccess(List<Description> descriptions);

        void onError();
    }
}
