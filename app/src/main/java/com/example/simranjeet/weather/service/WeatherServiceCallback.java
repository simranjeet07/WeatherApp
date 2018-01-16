package com.example.simranjeet.weather.service;

import com.example.simranjeet.weather.data.Channel;

/**
 * Created by simranjeet on 6/21/2017.
 */
public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}
