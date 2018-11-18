package com.top.movie.rubicon.main.movie;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.TvShow;
import com.top.movie.rubicon.databinding.MovieFragBinding;
import com.top.movie.rubicon.util.RecyclerViewClickListener;
import com.top.movie.rubicon.util.ViewModelFactory;

public class MovieFragment extends Fragment implements RecyclerViewClickListener {

    private MovieFragBinding mBinding;
    private MovieViewModel mMovieViewModel;
    private MovieAdapter mMovieAdapter;

    public static MovieFragment newInstance() {
        return new MovieFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = MovieFragBinding.inflate(inflater, container, false);

        mMovieViewModel = ViewModelFactory.obtainViewModel(getActivity(), getActivity(), MovieViewModel.class);
        mMovieViewModel.start();
        mBinding.setViewModel(mMovieViewModel);

        setupRv();
        return mBinding.getRoot();
    }


    /*************************
     * RecycleViewAdapter
     **********************/
    public void setupRv() {

        mMovieAdapter = new MovieAdapter(getActivity(), MovieFragment.this);

        mBinding.rvMovie.setLayoutManager(new LinearLayoutManager(
                getActivity(),
                LinearLayoutManager.VERTICAL,
                false));
        mBinding.rvMovie.setAdapter(mMovieAdapter);
    }

    @Override
    public void movieCLickListener(View v, Movie movie) {

        mMovieViewModel.getOpenShopEvent().setValue(movie);
    }

    @Override
    public void showCLickListener(View v, TvShow tvShow) {

    }
}