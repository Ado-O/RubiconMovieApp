package com.top.movie.rubicon.main.showdesc;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.top.movie.rubicon.R;
import com.top.movie.rubicon.data.TvShow;
import com.top.movie.rubicon.databinding.ShowDescActBinding;
import com.top.movie.rubicon.util.ActivityUtils;

public class ShowDescActivity extends AppCompatActivity {

    private ShowDescActBinding mShowDescActBinding;

    public static void startActivity(Activity activity, TvShow tvShow) {

        Intent intent = new Intent(activity, ShowDescActivity.class);
        intent.putExtra("show", tvShow);
        activity.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.show_desc_act);
        mShowDescActBinding = DataBindingUtil.setContentView(this, R.layout.show_desc_act);

        setupFragment();
    }

    /**
     * Fragment
     */
    private void setupFragment() {
        ShowDescFragment showDescFragment = (ShowDescFragment) getSupportFragmentManager().findFragmentById(mShowDescActBinding.fragShowDesc.getId());
        if (showDescFragment == null) {
            showDescFragment = ShowDescFragment.newInstance(getIntent().getParcelableExtra("show"));
            ActivityUtils.replaceFragmentInActivity(
                    getSupportFragmentManager(), showDescFragment, R.id.frag_showDesc
            );
        }
    }
}
