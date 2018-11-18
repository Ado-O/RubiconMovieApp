package com.top.movie.rubicon.util;

import android.view.View;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.TvShow;

public interface RecyclerViewClickListener {

    void movieCLickListener(View v, Movie movie);

    void showCLickListener(View v, TvShow tvShow);

}
