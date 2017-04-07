package com.weather.common;

/**
 * Base interface that must be implemented by a View layer class.
 */
public interface GenericView {

    /**
     * Return a boolean to indicate whether the view is active,
     * in order to check whether it is still able to handle UI updates.
     *
     * @return boolean active indicator
     */
    boolean isActive();

}
