package com.weather.forecasts;

import com.weather.common.GenericPresenter;
import com.weather.common.GenericView;
import com.weather.data.Forecast;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Contract between the view, the presenter and the interactor.
 */
interface ForecastsContract {

    interface View extends GenericView {

        void setProgressIndicator(boolean active);

        void showForecasts(List<Forecast> forecasts);

        void showForecastsLoadingError();

        void showForecastDetailsUi(@NonNull Forecast forecast);
    }

    interface ForecastItemListener {

        void onForecastClick(Forecast clickedForecast);

    }

    interface Presenter extends GenericPresenter {

        void loadForecasts();

        void openForecastDetails(@NonNull Forecast forecast);
    }

    interface LoadForecastsCallback {

        void onForecastsLoaded(List<Forecast> forecasts);

        void onDataNotAvailable();

    }

    interface Interactor {

        void getForecasts(@NonNull LoadForecastsCallback callback);

    }
}
