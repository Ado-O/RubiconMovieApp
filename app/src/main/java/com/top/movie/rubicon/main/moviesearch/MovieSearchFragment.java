package com.top.movie.rubicon.main.moviesearch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.TvShow;
import com.top.movie.rubicon.databinding.MovieSearchFragBinding;
import com.top.movie.rubicon.main.movie.MovieAdapter;
import com.top.movie.rubicon.main.movie.MovieViewModel;
import com.top.movie.rubicon.util.RecyclerViewClickListener;
import com.top.movie.rubicon.util.ViewModelFactory;

public class MovieSearchFragment extends Fragment implements RecyclerViewClickListener {

    public static final String TAG = MovieSearchFragment.class.getSimpleName();

    private MovieSearchFragBinding mBinding;
    private MovieSearchViewModel mMovieSearchViewModel;
    private MovieSearchAdapter mMovieSearchAdapter;
    private MovieAdapter mMovieAdapter;
    private String word;

    public static MovieSearchFragment newInstance(int id) {

        MovieSearchFragment fragment = new MovieSearchFragment();
        Bundle b = new Bundle();
        b.putInt("id", id);
        fragment.setArguments(b);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = MovieSearchFragBinding.inflate(inflater, container, false);

        mMovieSearchViewModel = ViewModelFactory.obtainViewModel(getActivity(), getActivity(), MovieSearchViewModel.class);
        mMovieSearchViewModel.startMovie(word);
        mBinding.setViewModel(mMovieSearchViewModel);

        setupBack();
        getData();
        setupRv();
        return mBinding.getRoot();
    }

    public void setupBack() {
       mBinding.tvSearch.setOnClickListener(v -> {
          getActivity().onBackPressed();
       });
    }

    public void getData() {

        mBinding.etSimple.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().isEmpty()) {
                    mMovieSearchViewModel.getMovie();
                } else {
                    mMovieSearchViewModel.getMovieSearch(s.toString());
                }
            }
        });
    }

    /*************************
     * RecycleViewAdapter
     **********************/
    public void setupRv() {

        mMovieAdapter = new MovieAdapter(getActivity(), MovieSearchFragment.this);

        mBinding.rvMovieSearch.setLayoutManager(new LinearLayoutManager(
                getActivity(),
                LinearLayoutManager.VERTICAL,
                false));
        mBinding.rvMovieSearch.setAdapter(mMovieAdapter);
    }


    @Override
    public void movieCLickListener(View v, Movie movie) {
        mMovieSearchViewModel.getOpenShopEvent().setValue(movie);
    }

    @Override
    public void showCLickListener(View v, TvShow tvShow) {

    }
}