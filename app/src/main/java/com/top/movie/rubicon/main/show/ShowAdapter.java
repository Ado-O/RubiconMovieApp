package com.top.movie.rubicon.main.show;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.top.movie.rubicon.data.Show;
import com.top.movie.rubicon.databinding.ShowItemBinding;
import com.top.movie.rubicon.util.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter {

    private List<Show> items = new ArrayList<>();
    private RecyclerViewClickListener mListener;
    private LayoutInflater mInflater;

    public ShowAdapter(Context context, RecyclerViewClickListener listener) {
        mInflater = LayoutInflater.from(context);
        mListener = listener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ShowViewHolder(
                ShowItemBinding.inflate(
                        mInflater,
                        viewGroup,
                        false
                ), mListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ShowViewHolder) viewHolder).setup(items.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

//    public void setItem(List list){
//        items.clear();
//        items.addAll(list);
//        notifyDataSetChanged();
//    }

    public void setItems(List list) {
        List oldItems = this.items;
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new Callback(oldItems, list));
        this.items.clear();
        this.items.addAll(list);
        result.dispatchUpdatesTo(this);
    }

    static class Callback extends DiffUtil.Callback {

        private final List mOldItems;
        private final List mNewItems;

        Callback(List<Show> oldItems, List<Show> newItems) {
            mOldItems = oldItems;
            mNewItems = newItems;
        }

        @Override
        public int getOldListSize() {
            return mOldItems.size();
        }

        @Override
        public int getNewListSize() {
            return mNewItems.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            if (mOldItems.get(oldItemPosition) instanceof Show && mNewItems.get(newItemPosition) instanceof Show) {
                return ((Show) mOldItems.get(oldItemPosition)).getId() == ((Show) mNewItems.get(newItemPosition)).getId();

            } else {
                return false;
            }
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return mOldItems.get(oldItemPosition).equals(mNewItems.get(newItemPosition));
        }
    }
}

