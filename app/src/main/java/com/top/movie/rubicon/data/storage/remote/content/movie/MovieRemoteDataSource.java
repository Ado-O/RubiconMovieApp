package com.top.movie.rubicon.data.storage.remote.content.movie;

import android.content.Context;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.converter.RemoteToLocal;
import com.top.movie.rubicon.data.storage.remote.ServiceGenerator;
import com.top.movie.rubicon.data.storage.remote.response.movieresponse.MovieBaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRemoteDataSource {

    private static final String TAG = MovieRemoteDataSource.class.getSimpleName();

    private static MovieRemoteDataSource sInstance = null;
    private final Context mContext;

    public MovieRemoteDataSource(Context context){
        mContext = context;
    }

    public static MovieRemoteDataSource getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new MovieRemoteDataSource(context);
        }
        return sInstance;
    }

    /**
     * Getting the content from the content url
     *
     * @param callback
     */
    public void getMovie(final GetMovieCallback callback) {
        MovieService movieService = ServiceGenerator.createService(MovieService.class);

        movieService
                .getMovies("popular", "c7720ac64a6580dc890bb503e5f55335","en-US",1)
                .enqueue(new Callback<MovieBaseResponse>() {
                    @Override
                    public void onResponse(Call<MovieBaseResponse> call, Response<MovieBaseResponse> response) {
                        if (response.isSuccessful()) {


                            callback.onSuccess(
                                    RemoteToLocal.movieConverter(
                                            response.body().getMovieResponses()
                                    )
                            );

                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieBaseResponse> call, Throwable t) {

                    }
                });
    }

    public interface GetMovieCallback {
        void onSuccess(List<Movie> movies);

        void onError();
    }
}
