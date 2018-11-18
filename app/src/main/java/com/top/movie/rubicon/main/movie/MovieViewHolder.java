package com.top.movie.rubicon.main.movie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.databinding.MovieItemBinding;
import com.top.movie.rubicon.util.RecyclerViewClickListener;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private MovieItemBinding mMovieItemBinding;

    public MovieViewHolder(@NonNull MovieItemBinding movieItemBinding,
                           RecyclerViewClickListener listener) {
        super(movieItemBinding.getRoot());
        mMovieItemBinding = movieItemBinding;
        movieItemBinding.setListener(listener);
    }

    public void setup(Movie movie){
        mMovieItemBinding.setMovie(movie);
    }
}
