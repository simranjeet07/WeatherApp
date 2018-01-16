package com.example.simranjeet.weather.data;



import org.json.JSONObject;

public class Units implements JSONPopulator {
    private String temperature;

    public String getTemperature() {
        return temperature;
    }
    public void poupulate(JSONObject data) {
        temperature=data.optString("temperature");
    }
}

