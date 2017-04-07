package com.weather.data;

/**
 * Forecast entity class
 */
public class Forecast {

    private String date;
    private String weather;
    private String high;
    private String low;

    public Forecast(String date, String weather, String high, String low) {
        this.date = date;
        this.weather = weather;
        this.high = high;
        this.low = low;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }
}
