package com.example.simranjeet.weather;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.example.simranjeet.weather.data.Channel;
import com.example.simranjeet.weather.data.Item;
import com.example.simranjeet.weather.service.WeatherServiceCallback;
import com.example.simranjeet.weather.service.YahooWeatherService;

public class weatherActivity extends AppCompatActivity implements WeatherServiceCallback {
    private ImageView weatherIconImageView;
    private TextView temperatureTextView;
    private TextView conditionTextView;
    private TextView locationTextView;
    private YahooWeatherService service;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        weatherIconImageView=(ImageView)findViewById(R.id.weatherIconImageView);
        temperatureTextView=(TextView)findViewById(R.id.temperatureTextView);
        conditionTextView=(TextView)findViewById(R.id.conditionTextView);
        locationTextView=(TextView)findViewById(R.id.locationTextView);
        service=new YahooWeatherService(this);
        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();
        Bundle data=getIntent().getExtras();
        String str=data.getString("city");
        service.refreshWeather(str);
    }


    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();
        Item item = channel.getItem();
        int resourceID=getResources().getIdentifier("drawable/icon_" + item.getCondition().getCode(), null, getPackageName());
        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable=getResources().getDrawable(resourceID);
        weatherIconImageView.setImageDrawable(weatherIconDrawable);
        temperatureTextView.setText(item.getCondition().getTemperature() + "\u00B0" + channel.getUnits().getTemperature());
        conditionTextView.setText(item.getCondition().getDescription());
        locationTextView.setText(service.getLocation());
    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this,exception.getMessage(),Toast.LENGTH_LONG).show();
    }
}
