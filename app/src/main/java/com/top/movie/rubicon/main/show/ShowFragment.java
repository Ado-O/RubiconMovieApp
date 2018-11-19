package com.top.movie.rubicon.main.show;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.Show;
import com.top.movie.rubicon.databinding.ShowFragBinding;
import com.top.movie.rubicon.util.RecyclerViewClickListener;
import com.top.movie.rubicon.util.ViewModelFactory;


public class ShowFragment extends Fragment implements RecyclerViewClickListener {

    private ShowFragBinding mBinding;
    private ShowViewModel mShowViewModel;
    private ShowAdapter mShowAdapter;

    public static ShowFragment newInstance() {
        return new ShowFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = ShowFragBinding.inflate(inflater, container, false);

        mShowViewModel = ViewModelFactory.obtainViewModel(getActivity(), getActivity(), ShowViewModel.class);
        mShowViewModel.start();
        mBinding.setViewModel(mShowViewModel);

        setupRv();
        return mBinding.getRoot();
    }


    /***********************
     * RecycleViewAdapter
     **********************/
    public void setupRv() {

        mShowAdapter = new ShowAdapter(getActivity(), ShowFragment.this);

        mBinding.rvShow.setLayoutManager(new LinearLayoutManager(
                getActivity(),
                LinearLayoutManager.VERTICAL,
                false));
        mBinding.rvShow.setAdapter(mShowAdapter);
    }

    /*****************
     * Clicklistener
     ****************/
    @Override
    public void movieCLickListener(View v, Movie movie) {

    }

    @Override
    public void showCLickListener(View v, Show show) {

        mShowViewModel.getOpenShopEvent().setValue(show);

    }
}