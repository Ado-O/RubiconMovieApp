package com.top.movie.rubicon.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.FragmentActivity;

import com.top.movie.rubicon.Injection;
import com.top.movie.rubicon.data.storage.MovieRepository;
import com.top.movie.rubicon.data.storage.MovieSearchRepository;
import com.top.movie.rubicon.data.storage.ShowRepository;
import com.top.movie.rubicon.data.storage.ShowSearchRepository;
import com.top.movie.rubicon.main.movie.MovieViewModel;
import com.top.movie.rubicon.main.moviesearch.MovieSearchViewModel;
import com.top.movie.rubicon.main.show.ShowViewModel;
import com.top.movie.rubicon.main.showsearch.ShowSearchViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile ViewModelFactory INSTANCE;

    private final Application mApplication;

    private Context mContext;
    private final MovieRepository mMovieRepository;
    private final ShowRepository mShowRepository;
    private final MovieSearchRepository mMovieSearchRepository;
    private final ShowSearchRepository mShowSearchRepository;

    public static ViewModelFactory getInstance(Application application, Context context) {

        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(
                            application,
                            context,
                            Injection.provideMovieRepository(application),
                            Injection.provideShowRepository(application),
                            Injection.provideMovieSearchRepository(application),
                            Injection.provideShowSearchRepository(application)
                    );
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    private ViewModelFactory(Application application,
                             Context context,
                             MovieRepository movieRepository,
                             ShowRepository showRepository,
                             MovieSearchRepository movieSearchRepository,
                             ShowSearchRepository showSearchRepository) {
        mApplication = application;
        mContext = context;
        mMovieRepository = movieRepository;
        mShowRepository = showRepository;
        mMovieSearchRepository = movieSearchRepository;
        mShowSearchRepository = showSearchRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(mApplication, mContext);
        }else if (modelClass.isAssignableFrom(ShowViewModel.class)) {
            return (T) new ShowViewModel(mApplication, mContext);
        }else if (modelClass.isAssignableFrom(MovieSearchViewModel.class)) {
            return (T) new MovieSearchViewModel(mApplication, mContext);
        }else if (modelClass.isAssignableFrom(ShowSearchViewModel.class)) {
            return (T) new ShowSearchViewModel(mApplication, mContext);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }

    public static <T extends AndroidViewModel> T obtainViewModel(FragmentActivity activity, Context context, Class<T> modelClass) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication(), context);

        T viewModel =
                ViewModelProviders.of(activity, factory).get(modelClass);

        return viewModel;
    }
}