package com.weather.forecasts;

import com.weather.data.Forecast;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Presenter for the View {@link ForecastsFragment}
 */
class ForecastsPresenter implements ForecastsContract.Presenter, ForecastsContract.LoadForecastsCallback {

    /**
     * Forecasts view
     */
    final private WeakReference<ForecastsContract.View> mForecastsView;

    /**
     * Forecasts interactor
     */
    private ForecastsInteractor mForecastsInteractor;

    ForecastsPresenter(@NonNull ForecastsContract.View forecastsView) {
        mForecastsView = new WeakReference<>(forecastsView);
        mForecastsInteractor = new ForecastsInteractor();
    }

    @Override
    public void start() {
        loadForecasts();
    }

    @Override
    public void onDestroy() {
        // Call local repository destroy method
    }

    @Override
    public void loadForecasts() {
        // Display progress indicator
        if (mForecastsView.get() != null && mForecastsView.get().isActive()) {
            mForecastsView.get().setProgressIndicator(true);
        }
        // Get forecasts
        mForecastsInteractor.getForecasts(this);
    }

    @Override
    public void openForecastDetails(@NonNull Forecast forecast) {
        if (mForecastsView.get() != null) {
            mForecastsView.get().showForecastDetailsUi(forecast);
        }
    }

    @Override
    public void onForecastsLoaded(List<Forecast> forecasts) {
        if (mForecastsView.get() != null && mForecastsView.get().isActive()) {
            // Hide progress indicator
            mForecastsView.get().setProgressIndicator(false);
            // Display forecasts
            mForecastsView.get().showForecasts(forecasts);
        }
    }

    @Override
    public void onDataNotAvailable() {
        if (mForecastsView.get() != null && mForecastsView.get().isActive()) {
            // Hide progress indicator
            mForecastsView.get().setProgressIndicator(false);
            // Display forecasts loading error
            mForecastsView.get().showForecastsLoadingError();
        }
    }
}
