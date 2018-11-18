package com.top.movie.rubicon.main.movie;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieBinding {

    public static final String TAG = MovieBinding.class.getSimpleName();

    /*********************
     * call image throw Glide
     *********************/
    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:loadImage"})
    public static void setImage(ImageView view, String img) {

        Glide.with(view.getContext())
                .load("https://image.tmdb.org/t/p/original"+img)
                .into(view);
    }

    /*************************
     * add list with use RecyclerView adapter
     ************************/
    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:movieItem"})
    public static void setMovieItem(RecyclerView recyclerView, List movieItems) {

        if (movieItems != null && movieItems.size() > 0) {
            ((MovieAdapter) recyclerView.getAdapter()).setItems(movieItems);
        }
    }
}
