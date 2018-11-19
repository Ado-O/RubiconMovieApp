package com.top.movie.rubicon.main.showsearch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.Show;
import com.top.movie.rubicon.databinding.ShowSearchFragBinding;
import com.top.movie.rubicon.main.show.ShowAdapter;
import com.top.movie.rubicon.util.RecyclerViewClickListener;
import com.top.movie.rubicon.util.ViewModelFactory;

import static com.top.movie.rubicon.main.MainActivity.hideKeyboard;

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
        setupHide();
        getData();
        setupRv();
        return mBinding.getRoot();
    }

    /***********
     * back button
     **********/
    public void setupBack() {
        mBinding.tvSearch.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });
    }

    /**************************************
     * when onScroll recycleview hide keyboard
     ****************************************/
    public void setupHide() {
        //put down keyboard when on touch
        mBinding.rvShowSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                hideKeyboard(getActivity());
                return false;
            }
        });
    }

    /*************************************
     * send data from EditText in viewModel
     *************************************/
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

    /******************
     * onClickListener
     ******************/
    @Override
    public void movieCLickListener(View v, Movie movie) {

    }

    @Override
    public void showCLickListener(View v, Show show) {
        mShowSearchViewModel.getOpenShopEvent().setValue(show);

    }
}