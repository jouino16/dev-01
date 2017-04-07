package com.weather.forecasts;

import com.weather.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastsActivity extends AppCompatActivity {

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Bind view
        setContentView(R.layout.forcasts_activity);
        ButterKnife.bind(this);

        // Set action bar
        setSupportActionBar(mToolbar);

        ForecastsFragment forecastsFragment = (ForecastsFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (null == forecastsFragment) {
            forecastsFragment = ForecastsFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contentFrame, forecastsFragment)
                    .commit();
        }
    }

    public void enableCollapsingToolbarScrolling(boolean enable) {
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) mCollapsingToolbarLayout.getLayoutParams();
        if (enable) {
            params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
        } else {
            params.setScrollFlags(0);
        }
        mCollapsingToolbarLayout.setLayoutParams(params);
    }
}
