package com.weather.forecasts;

import com.weather.data.Forecast;

import android.os.Handler;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Interactor (use case) for retrieving forecasts
 * Should make use of data repositories and network service in order to process data.
 */
class ForecastsInteractor implements ForecastsContract.Interactor {

    private static final int LATENCY = 1000; // 1s

    @Override
    public void getForecasts(@NonNull final ForecastsContract.LoadForecastsCallback callback) {
        // Simulated forecast loading
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onForecastsLoaded(getMockedForecasts());
            }
        }, LATENCY);
    }

    private List<Forecast> getMockedForecasts() {
        List<Forecast> forecasts = new ArrayList<>();
        forecasts.add(new Forecast("Today, April 06", "Heavy Rain", "14°", "10°"));
        forecasts.add(new Forecast("Tomorrow", "Moderate Rain", "13°", "12°"));
        forecasts.add(new Forecast("Saturday", "Moderate Rain", "13°", "8°"));
        forecasts.add(new Forecast("Sunday", "Light Rain", "12°", "6°"));
        forecasts.add(new Forecast("Monday", "Clear", "15°", "6°"));
        forecasts.add(new Forecast("Tuesday", "Clear", "16°", "8°"));
        forecasts.add(new Forecast("Wednesday", "Clear", "19°", "9°"));
        forecasts.add(new Forecast("Thu Apr 13", "Heavy Rain", "17°", "11°"));
        forecasts.add(new Forecast("Fri Apr 14", "Heavy Rain", "15°", "8°"));
        forecasts.add(new Forecast("Sat Apr 16", "Heavy Rain", "16°", "8°"));
        forecasts.add(new Forecast("Mon Apr 17", "Heavy Rain", "14°", "9°"));
        forecasts.add(new Forecast("Tue Apr 18", "Heavy Rain", "14°", "10°"));


        forecasts.add(new Forecast("Today, April 06", "Heavy Rain", "14°", "10°"));
        forecasts.add(new Forecast("Tomorrow", "Moderate Rain", "13°", "12°"));
        forecasts.add(new Forecast("Saturday", "Moderate Rain", "13°", "8°"));
        forecasts.add(new Forecast("Sunday", "Light Rain", "12°", "6°"));
        forecasts.add(new Forecast("Monday", "Clear", "15°", "6°"));
        forecasts.add(new Forecast("Tuesday", "Clear", "16°", "8°"));
        forecasts.add(new Forecast("Wednesday", "Clear", "19°", "9°"));
        forecasts.add(new Forecast("Thu Apr 13", "Heavy Rain", "17°", "11°"));
        forecasts.add(new Forecast("Fri Apr 14", "Heavy Rain", "15°", "8°"));
        forecasts.add(new Forecast("Sat Apr 16", "Heavy Rain", "16°", "8°"));
        forecasts.add(new Forecast("Mon Apr 17", "Heavy Rain", "14°", "9°"));
        forecasts.add(new Forecast("Tue Apr 18", "Heavy Rain", "14°", "10°"));

        forecasts.add(new Forecast("Today, April 06", "Heavy Rain", "14°", "10°"));
        forecasts.add(new Forecast("Tomorrow", "Moderate Rain", "13°", "12°"));
        forecasts.add(new Forecast("Saturday", "Moderate Rain", "13°", "8°"));
        forecasts.add(new Forecast("Sunday", "Light Rain", "12°", "6°"));
        forecasts.add(new Forecast("Monday", "Clear", "15°", "6°"));
        forecasts.add(new Forecast("Tuesday", "Clear", "16°", "8°"));
        forecasts.add(new Forecast("Wednesday", "Clear", "19°", "9°"));
        forecasts.add(new Forecast("Thu Apr 13", "Heavy Rain", "17°", "11°"));
        forecasts.add(new Forecast("Fri Apr 14", "Heavy Rain", "15°", "8°"));
        forecasts.add(new Forecast("Sat Apr 16", "Heavy Rain", "16°", "8°"));
        forecasts.add(new Forecast("Mon Apr 17", "Heavy Rain", "14°", "9°"));
        forecasts.add(new Forecast("Tue Apr 18", "Heavy Rain", "14°", "10°"));

        return forecasts;
    }

}
