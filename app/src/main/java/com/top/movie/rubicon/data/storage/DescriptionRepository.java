package com.top.movie.rubicon.data.storage;

import com.top.movie.rubicon.data.Description;
import com.top.movie.rubicon.data.storage.remote.content.description.DescriptionRemoteDataSource;

import java.util.List;

public class DescriptionRepository {

    public static final String TAG = DescriptionRepository.class.getSimpleName();

    private static DescriptionRepository sInstance = null;

    private final DescriptionRemoteDataSource mDescriptionRemoteDataSource;

    public DescriptionRepository(DescriptionRemoteDataSource descriptionRemoteDataSource) {
        mDescriptionRemoteDataSource = descriptionRemoteDataSource;
    }

    public static DescriptionRepository getInstance(DescriptionRemoteDataSource descriptionRemoteDataSource) {
        if (sInstance == null) {
            sInstance = new DescriptionRepository(descriptionRemoteDataSource);
        }
        return sInstance;
    }

    public void getDescription(int id, final GetDescriptionCallback callback) {
        mDescriptionRemoteDataSource.getDescription(id, new DescriptionRemoteDataSource.GetDescriptionCallback() {
            @Override
            public void onSuccess(List<Description> descriptions) {
                callback.onSuccess(descriptions);
            }

            @Override
            public void onError() {

            }
        });
    }

    public interface GetDescriptionCallback {
        void onSuccess(List<Description> description);

        void onError();
    }
}
