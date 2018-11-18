package com.top.movie.rubicon.main.moviesearch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.databinding.MovieSearchItemBinding;
import com.top.movie.rubicon.util.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.List;

public class MovieSearchAdapter extends RecyclerView.Adapter {

    private List<Movie> items = new ArrayList<>();
    private RecyclerViewClickListener mListener;
    private LayoutInflater mInflater;

    public MovieSearchAdapter(Context context,
                              RecyclerViewClickListener listener) {
        mInflater = LayoutInflater.from(context);
        mListener = listener;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MovieSearchViewHolder(
                MovieSearchItemBinding.inflate(
                        mInflater,
                        viewGroup,
                        false
                ), mListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MovieSearchViewHolder) viewHolder).setup(items.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItem(List list){
        items.clear();
        items.addAll(list);
        notifyDataSetChanged();
    }
}
