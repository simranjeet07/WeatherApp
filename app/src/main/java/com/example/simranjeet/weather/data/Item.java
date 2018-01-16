package com.example.simranjeet.weather.data;


import org.json.JSONObject;

/**
 * Created by simranjeet on 6/21/2017.
 */
public class Item implements JSONPopulator {
    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void poupulate(JSONObject data) {
        condition=new Condition();
        condition.poupulate(data.optJSONObject("condition"));
    }
}
