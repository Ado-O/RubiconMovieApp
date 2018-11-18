package com.top.movie.rubicon.main.moviesearch;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class SearchBinding {

    /*************************
     * add list with use RecyclerView adapter
     ************************/
    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:searchItem"})
    public static void setSearchItem(RecyclerView recyclerView,
                                     List searchItem) {

        if (searchItem != null) {
            ((MovieSearchAdapter) recyclerView.getAdapter()).setItem(searchItem);
        }
    }
}
