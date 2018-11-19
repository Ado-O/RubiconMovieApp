package com.top.movie.rubicon.data.storage;

import com.top.movie.rubicon.data.Show;
import com.top.movie.rubicon.data.storage.remote.content.show.ShowRemoteDataSource;

import java.util.List;

public class ShowRepository {

    public static final String TAG = ShowRepository.class.getSimpleName();

    private static ShowRepository sInstance = null;

    private final ShowRemoteDataSource mShowRemoteDataSource;

    public ShowRepository(ShowRemoteDataSource showRemoteDataSource) {
        mShowRemoteDataSource = showRemoteDataSource;
    }

    public static ShowRepository getInstance(ShowRemoteDataSource showRemoteDataSource) {
        if (sInstance == null) {
            sInstance = new ShowRepository(showRemoteDataSource);
        }
        return sInstance;
    }

    public void getShow(final GetShowCallback callback) {
       mShowRemoteDataSource.getTvShow(new ShowRemoteDataSource.GetShowCallback() {
           @Override
           public void onSuccess(List<Show> shows) {
               callback.onSuccess(shows);

           }

           @Override
           public void onError() {

           }
       });


    }

    public interface GetShowCallback {
        void onSuccess(List<Show> shows);

        void onError();
    }


}
