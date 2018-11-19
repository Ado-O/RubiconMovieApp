package com.top.movie.rubicon.util;

import android.view.View;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.Show;

public interface RecyclerViewClickListener {

    void movieCLickListener(View v, Movie movie);

    void showCLickListener(View v, Show show);

}
