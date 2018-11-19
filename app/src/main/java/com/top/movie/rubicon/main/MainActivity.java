package com.top.movie.rubicon.main;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.top.movie.rubicon.R;
import com.top.movie.rubicon.databinding.MainActBinding;
import com.top.movie.rubicon.main.movie.MovieFragment;
import com.top.movie.rubicon.main.movie.MovieViewModel;
import com.top.movie.rubicon.main.moviedesc.MovieDescActivity;
import com.top.movie.rubicon.main.moviesearch.MovieSearchActivity;
import com.top.movie.rubicon.main.moviesearch.MovieSearchViewModel;
import com.top.movie.rubicon.main.show.ShowFragment;
import com.top.movie.rubicon.main.show.ShowViewModel;
import com.top.movie.rubicon.main.showdesc.ShowDescActivity;
import com.top.movie.rubicon.main.showsearch.ShowSearchActivity;
import com.top.movie.rubicon.main.showsearch.ShowSearchViewModel;
import com.top.movie.rubicon.util.ViewModelFactory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private MainActBinding mMainActBinding;
    private MainAdapter mMainAdapter;
    private MovieViewModel mMovieViewModel;
    private ShowViewModel mShowViewModel;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main_act);

        mMainActBinding = DataBindingUtil.setContentView(this, R.layout.main_act);
        mMovieViewModel = ViewModelFactory.obtainViewModel(this, this, MovieViewModel.class);
        mShowViewModel = ViewModelFactory.obtainViewModel(this, this, ShowViewModel.class);

        setupToolbar();
        setupTablistener();
        setupPager();
        setupSearch();
        setupEvent();
    }

    /*********
     * toolbar
     **********/
    private void setupToolbar() {
        setSupportActionBar(mMainActBinding.tbMain);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    /**********************
     * setting overflow menu
     ***********************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /****************************
     * setupTablistener add text
     ****************************/
    public void setupTablistener() {
        //add tab items with title..
        mMainActBinding.tlMain.addTab(mMainActBinding.tlMain.newTab().setText("MOVIES"));
        mMainActBinding.tlMain.addTab(mMainActBinding.tlMain.newTab().setText("TV SHOWS"));
        mMainActBinding.tlMain.setTabGravity(TabLayout.GRAVITY_FILL);

        mMainActBinding.vpMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mMainActBinding.tlMain));
        //add listener and forse to be onClick
        mMainActBinding.tlMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mMainActBinding.vpMain.setCurrentItem(tab.getPosition());
                position = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //onTabSelected and onTabUnselected are called every time there is a change in tabs.
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //onTabReselected is called whenever a tab is clicked again while it is already showing.
            }
        });
    }

    /**************************************
     * Setting up the listView & its adapter
     *************************************/
    private void setupPager() {

        //create arrayList and edit fragment
        ArrayList<Fragment> arrayList = new ArrayList<>();
        arrayList.add(MovieFragment.newInstance());
        arrayList.add(ShowFragment.newInstance());

        mMainAdapter = new MainAdapter(getSupportFragmentManager(), arrayList);
        mMainActBinding.vpMain.setAdapter(mMainAdapter);
    }

    /**************************************
     * check if what position is movie or show
     *************************************/
    public void setupSearch() {
        mMainActBinding.ivSearch.setOnClickListener(v -> {

            if (position == 1){
                ShowSearchActivity.startActivity(MainActivity.this, position);
            }else{
                MovieSearchActivity.startActivity(MainActivity.this, position);
            }
        });
    }

    /***************************************************
     * forse to hide keyboard when user scroll recycleview
     **************************************************/
    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View currentFocusedView = activity.getCurrentFocus();
        if (currentFocusedView != null) {
            inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /***********************************
     * send data to description activity
     ***********************************/
    public void setupEvent() {

        mMovieViewModel.getOpenShopEvent().observe(MainActivity.this, movie ->
                MovieDescActivity.startActivity(MainActivity.this, movie)
        );

        mShowViewModel.getOpenShopEvent().observe(MainActivity.this, tvShow ->
                ShowDescActivity.startActivity(MainActivity.this, tvShow)
        );

    }
}
