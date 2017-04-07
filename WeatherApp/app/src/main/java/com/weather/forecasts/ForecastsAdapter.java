package com.weather.forecasts;

import com.weather.R;
import com.weather.data.Forecast;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Adapter for weather forecast list
 */
class ForecastsAdapter extends RecyclerView.Adapter<ForecastsAdapter.ForecastsAdapterViewHolder> {

    /**
     * Context
     */
    final private Context mContext;

    /**
     * Empty view to display when the forecast list is empty
     */
    final private View mEmptyView;

    /**
     * Listener on forecast items
     */
    final private ForecastsContract.ForecastItemListener mForecastItemListener;

    /**
     * Forecast list
     */
    private List<Forecast> mForecasts;

    /**
     * Constructor
     */
    ForecastsAdapter(Context context, View emptyView, ForecastsContract.ForecastItemListener forecastItemListener) {
        mContext = context;
        mEmptyView = emptyView;
        mForecastItemListener = forecastItemListener;
    }

    @Override
    public ForecastsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_forecast, parent, false);
        return new ForecastsAdapterViewHolder(view, mForecastItemListener);
    }

    @Override
    public void onBindViewHolder(ForecastsAdapterViewHolder holder, int position) {
        Forecast forecast = mForecasts.get(position);
        holder.mDateView.setText(forecast.getDate());
        holder.mWeatherView.setText(forecast.getWeather());
        holder.mHighView.setText(forecast.getHigh());
        holder.mLowView.setText(forecast.getLow());
    }

    @Override
    public int getItemCount() {
        return (null == mForecasts) ? 0 : mForecasts.size();
    }

    /**
     * Return Forecast item for a specific position
     *
     * @param position item position
     * @return Forecast item
     */
    private Forecast getItem(int position) {
        return mForecasts.get(position);
    }

    /**
     * Update data set
     *
     * @param forecasts new forecast data set
     */
    void swapDataSet(List<Forecast> forecasts) {
        mForecasts = forecasts;
        notifyDataSetChanged();
        mEmptyView.setVisibility((getItemCount() == 0) ? View.VISIBLE : View.GONE);
    }

    class ForecastsAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final ImageView mImageView;
        final TextView mDateView;
        final TextView mWeatherView;
        final TextView mHighView;
        final TextView mLowView;
        private final ForecastsContract.ForecastItemListener mForecastItemListener;

        ForecastsAdapterViewHolder(View itemView, ForecastsContract.ForecastItemListener listener) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.ic_weather);
            mDateView = (TextView) itemView.findViewById(R.id.tv_date);
            mWeatherView = (TextView) itemView.findViewById(R.id.tv_weather);
            mHighView = (TextView) itemView.findViewById(R.id.tv_high);
            mLowView = (TextView) itemView.findViewById(R.id.tv_low);
            mForecastItemListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Forecast forecast = getItem(getAdapterPosition());
            mForecastItemListener.onForecastClick(forecast);
        }
    }
}
