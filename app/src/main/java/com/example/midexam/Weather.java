package com.example.midexam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {

    @SerializedName("consolidated_weather")
    @Expose
    private List<Weather_> weather = null;

    public List<Weather_> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather_> weather) {
        this.weather = weather;
    }

}




