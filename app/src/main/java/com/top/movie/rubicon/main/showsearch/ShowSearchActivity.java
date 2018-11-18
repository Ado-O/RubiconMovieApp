package com.top.movie.rubicon.main.showsearch;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.top.movie.rubicon.R;
import com.top.movie.rubicon.databinding.ShowSearchActBinding;
import com.top.movie.rubicon.main.MainActivity;
import com.top.movie.rubicon.main.moviesearch.MovieSearchActivity;
import com.top.movie.rubicon.main.moviesearch.MovieSearchFragment;
import com.top.movie.rubicon.main.showdesc.ShowDescActivity;
import com.top.movie.rubicon.util.ActivityUtils;
import com.top.movie.rubicon.util.ViewModelFactory;

public class ShowSearchActivity extends AppCompatActivity {

    private ShowSearchActBinding mBinding;
    private ShowSearchViewModel mShowSearchViewModel;

    public static void startActivity(Activity activity, int id) {

        Intent intent = new Intent(activity, ShowSearchActivity.class);
        intent.putExtra("id", id);
        activity.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_search_act);

        mBinding = DataBindingUtil.setContentView(this, R.layout.show_search_act);
        mShowSearchViewModel = ViewModelFactory.obtainViewModel(this, this, ShowSearchViewModel.class);

        mShowSearchViewModel.getOpenShopEvent().observe(ShowSearchActivity.this, tvShow ->
                ShowDescActivity.startActivity(ShowSearchActivity.this, tvShow)
        );

        setupFragment();
    }

    /**
     * Fragment
     */
    private void setupFragment() {
        ShowSearchFragment showSearchFragment = (ShowSearchFragment) getSupportFragmentManager().findFragmentById(mBinding.fragShowSearch.getId());
        if (showSearchFragment == null) {
            showSearchFragment = ShowSearchFragment.newInstance(getIntent().getIntExtra("id", 0));
            ActivityUtils.replaceFragmentInActivity(
                    getSupportFragmentManager(), showSearchFragment, R.id.frag_show_search
            );
        }
    }
}