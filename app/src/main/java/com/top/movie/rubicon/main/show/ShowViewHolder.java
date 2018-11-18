package com.top.movie.rubicon.main.show;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.top.movie.rubicon.data.TvShow;
import com.top.movie.rubicon.databinding.ShowItemBinding;
import com.top.movie.rubicon.util.RecyclerViewClickListener;

public class ShowViewHolder extends RecyclerView.ViewHolder {

    private ShowItemBinding mShowItemBinding;

    public ShowViewHolder(@NonNull ShowItemBinding showItemBinding,
                          RecyclerViewClickListener listener) {
        super(showItemBinding.getRoot());
    mShowItemBinding = showItemBinding;
    mShowItemBinding.setListener(listener);
    }

    public void setup(TvShow tvShow){
        mShowItemBinding.setTvShow(tvShow);
    }
}
