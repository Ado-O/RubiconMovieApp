package com.top.movie.rubicon.main.show;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class ShowBinding {

    /*************************
     * add list with use RecyclerView adapter
     ************************/
    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:showItem"})
    public static void setShowItem(RecyclerView recyclerView, List showItems) {

        if (showItems != null && showItems.size() > 0) {
            ((ShowAdapter) recyclerView.getAdapter()).setItems(showItems);
        }
    }
}
