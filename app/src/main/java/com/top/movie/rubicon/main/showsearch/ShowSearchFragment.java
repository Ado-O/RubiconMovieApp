package com.top.movie.rubicon.main.showsearch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.TvShow;
import com.top.movie.rubicon.databinding.ShowSearchFragBinding;
import com.top.movie.rubicon.main.show.ShowAdapter;
import com.top.movie.rubicon.util.RecyclerViewClickListener;
import com.top.movie.rubicon.util.ViewModelFactory;

public class ShowSearchFragment extends Fragment implements RecyclerViewClickListener {

    public static final String TAG = ShowSearchFragment.class.getSimpleName();

    private ShowSearchFragBinding mBinding;
    private ShowSearchViewModel mShowSearchViewModel;
    private ShowAdapter mShowAdapter;
    private String word;

    public static ShowSearchFragment newInstance(int id) {

        ShowSearchFragment fragment = new ShowSearchFragment();
        Bundle b = new Bundle();
        b.putInt("id", id);
        fragment.setArguments(b);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = ShowSearchFragBinding.inflate(inflater, container, false);

        mShowSearchViewModel = ViewModelFactory.obtainViewModel(getActivity(), getActivity(), ShowSearchViewModel.class);
        mShowSearchViewModel.startShow(word);
        mBinding.setViewModel(mShowSearchViewModel);

        setupBack();
        getData();
        setupRv();
        return mBinding.getRoot();
    }
    public void setupBack() {
        mBinding.tvSearch.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });
    }

    public void getData() {

        mBinding.etSimple.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().isEmpty()) {
                    mShowSearchViewModel.getShow();
                } else {
                    mShowSearchViewModel.getShowSearch(s.toString());
                }
            }
        });
    }

    /*************************
     * RecycleViewAdapter
     **********************/
    public void setupRv() {

        mShowAdapter = new ShowAdapter(getActivity(), ShowSearchFragment.this);

        mBinding.rvShowSearch.setLayoutManager(new LinearLayoutManager(
                getActivity(),
                LinearLayoutManager.VERTICAL,
                false));
        mBinding.rvShowSearch.setAdapter(mShowAdapter);
    }

    @Override
    public void movieCLickListener(View v, Movie movie) {

    }

    @Override
    public void showCLickListener(View v, TvShow tvShow) {
        mShowSearchViewModel.getOpenShopEvent().setValue(tvShow);

    }
}