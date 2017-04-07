package com.weather.forecasts;

import com.weather.R;
import com.weather.data.Forecast;
import com.weather.util.Utils;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A view that displays a forecast list
 */
public class ForecastsFragment extends Fragment implements ForecastsContract.View, ForecastsContract.ForecastItemListener {

    @BindView(R.id.recyclerView_forecasts)
    RecyclerView mRecyclerView;

    @BindView(R.id.tv_empty_list)
    LinearLayout mEmptyListView;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    /**
     * Forecasts presenter
     */
    private ForecastsContract.Presenter mForecastsPresenter;

    /**
     * Forecast list adapter
     */
    private ForecastsAdapter mForecastsAdapter;

    /**
     * Required empty constructor
     */
    public ForecastsFragment() {
        // Required empty constructor
    }

    /**
     * Static method to instantiate ForecastsFragment
     *
     * @return ForecastsFragment instance
     */
    public static ForecastsFragment newInstance() {
        return new ForecastsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Bind view
        View rootView = inflater.inflate(R.layout.forecasts_fragment, container, false);
        ButterKnife.bind(this, rootView);

        // Set the layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        // Create adapter
        mForecastsAdapter = new ForecastsAdapter(getActivity(), mEmptyListView, this);

        // Bind adapter to recycler view
        mRecyclerView.setAdapter(mForecastsAdapter);

        // Create presenter
        mForecastsPresenter = new ForecastsPresenter(this);
        // Start presenter in order to start loading forecasts
        mForecastsPresenter.start();

        return rootView;
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setProgressIndicator(boolean active) {
        if (active) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showForecasts(List<Forecast> forecasts) {
        // Check whether to enable collapsing toolbar scrolling
        ((ForecastsActivity) getActivity()).enableCollapsingToolbarScrolling((forecasts != null && !forecasts.isEmpty()));
        // Update data set
        mForecastsAdapter.swapDataSet(forecasts);
    }

    @Override
    public void showForecastsLoadingError() {
        // Show no data & error message in snack bar
    }

    @Override
    public void showForecastDetailsUi(@NonNull Forecast forecast) {
        if (isActive()) {
            Utils.showToast(getActivity(), forecast.getWeather());
        }
    }

    @Override
    public void onForecastClick(Forecast clickedForecast) {
        mForecastsPresenter.openForecastDetails(clickedForecast);
    }
}
