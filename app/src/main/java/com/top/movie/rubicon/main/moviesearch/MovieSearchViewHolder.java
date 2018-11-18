package com.top.movie.rubicon.main.moviesearch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.Search;
import com.top.movie.rubicon.databinding.MovieSearchItemBinding;
import com.top.movie.rubicon.util.RecyclerViewClickListener;

public class MovieSearchViewHolder extends RecyclerView.ViewHolder {

    private MovieSearchItemBinding mBinding;

    public MovieSearchViewHolder(@NonNull MovieSearchItemBinding movieSearchItemBinding,
                                 RecyclerViewClickListener listener) {
        super(movieSearchItemBinding.getRoot());
        mBinding = movieSearchItemBinding;
        mBinding.setListener(listener);
    }

    public void setup(Movie movie){
        mBinding.setSearch(movie);
    }
}
