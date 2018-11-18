package com.top.movie.rubicon.main.moviesearch;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.top.movie.rubicon.R;
import com.top.movie.rubicon.databinding.MovieSearchActBinding;
import com.top.movie.rubicon.main.moviedesc.MovieDescActivity;
import com.top.movie.rubicon.util.ActivityUtils;
import com.top.movie.rubicon.util.ViewModelFactory;

public class MovieSearchActivity extends AppCompatActivity {

    public MovieSearchActBinding mBinding;
    private MovieSearchViewModel mMovieSearchViewModel;

    public static void startActivity(Activity activity, int id) {

        Intent intent = new Intent(activity, MovieSearchActivity.class);
        intent.putExtra("id", id);
        activity.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.movie_search_act);

        mBinding = DataBindingUtil.setContentView(this, R.layout.movie_search_act);

        mMovieSearchViewModel = ViewModelFactory.obtainViewModel(this, this, MovieSearchViewModel.class);

        mMovieSearchViewModel.getOpenShopEvent().observe(MovieSearchActivity.this, movie ->
                MovieDescActivity.startActivity(MovieSearchActivity.this, movie)
        );

        setupFragment();
    }

    /**
     * Fragment
     */
    private void setupFragment() {
        MovieSearchFragment movieSearchFragment = (MovieSearchFragment) getSupportFragmentManager().findFragmentById(mBinding.fragMovieSearch.getId());
        if (movieSearchFragment == null) {
            movieSearchFragment = MovieSearchFragment.newInstance(getIntent().getIntExtra("id", 0));
            ActivityUtils.replaceFragmentInActivity(
                    getSupportFragmentManager(), movieSearchFragment, R.id.frag_movie_search
            );
        }
    }
}
