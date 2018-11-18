package com.top.movie.rubicon.main.showdesc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.top.movie.rubicon.data.TvShow;
import com.top.movie.rubicon.databinding.ShowDescFragBinding;

public class ShowDescFragment extends Fragment {

    public static final String TAG = ShowDescFragment.class.getSimpleName();

    private ShowDescFragBinding mBinding;
    private TvShow t;

    public static ShowDescFragment newInstance(TvShow tvShow) {

        ShowDescFragment fragment = new ShowDescFragment();
        Bundle b = new Bundle();
        b.putParcelable("show", tvShow);
        fragment.setArguments(b);

        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = ShowDescFragBinding.inflate(inflater, container, false);

        t = getActivity().getIntent().getExtras().getParcelable("show");
        mBinding.setShow(t);

        setupToolbar();
        return mBinding.getRoot();
    }

    /**********
     * toolbar
     *********/
    public void setupToolbar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mBinding.tlb);

        //back button
        mBinding.ivBack.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });

    }
}