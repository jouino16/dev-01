package com.weather.common;

/**
 * Base interface that must be implemented by a Presenter layer class.
 */
public interface GenericPresenter {

    /**
     * Start presenter ops
     */
    void start();

    /**
     * On presenter destruction, may be invoked by the holding view.
     */
    void onDestroy();

}
