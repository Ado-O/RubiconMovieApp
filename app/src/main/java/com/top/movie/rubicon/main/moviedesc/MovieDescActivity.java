package com.top.movie.rubicon.main.moviedesc;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.top.movie.rubicon.R;
import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.databinding.MovieDescActBinding;
import com.top.movie.rubicon.util.ActivityUtils;

public class MovieDescActivity extends AppCompatActivity {

    private MovieDescActBinding mMovieDescActBinding;

    public static void startActivity(Activity activity, Movie movie) {

        Intent intent = new Intent(activity, MovieDescActivity.class);
        intent.putExtra("movie", movie);
        activity.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.movie_desc_act);

        mMovieDescActBinding = DataBindingUtil.setContentView(this, R.layout.movie_desc_act);
        setupFragment();
    }

    /**********
     * Fragment
     **********/
    private void setupFragment() {
        MovieDescFragment movieDescFragment = (MovieDescFragment) getSupportFragmentManager().findFragmentById(mMovieDescActBinding.fragDesc.getId());
        if (movieDescFragment == null) {
            movieDescFragment = MovieDescFragment.newInstance(getIntent().getParcelableExtra("movie"));
            ActivityUtils.replaceFragmentInActivity(
                    getSupportFragmentManager(), movieDescFragment, R.id.frag_desc
            );
        }
    }
}
