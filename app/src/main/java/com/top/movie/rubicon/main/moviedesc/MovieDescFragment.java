package com.top.movie.rubicon.main.moviedesc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.databinding.MovieDescFragBinding;

public class MovieDescFragment extends Fragment {

    private MovieDescFragBinding mBinding;
    private Movie m;

    public static MovieDescFragment newInstance(Movie movie) {

        MovieDescFragment fragment = new MovieDescFragment();
        Bundle b = new Bundle();
        b.putParcelable("movie", movie);
        fragment.setArguments(b);

        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = MovieDescFragBinding.inflate(inflater, container, false);

        m = getActivity().getIntent().getExtras().getParcelable("movie");
        mBinding.setMovie(m);

        setupToolbar();
        return mBinding.getRoot();
    }

    /**********
     * toolbar
     *********/
    public void setupToolbar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mBinding.tlb);

        //back button
        mBinding.ivBack.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });

    }
}