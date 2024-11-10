package com.example.weatherservice.model;

public class WeatherResponse {
    private String shortForecast;
    private String temperatureCategory;

    public WeatherResponse(String shortForecast, String temperatureCategory) {
        this.shortForecast = shortForecast;
        this.temperatureCategory = temperatureCategory;
    }

    public String getShortForecast() {
        return shortForecast;
    }

    public void setShortForecast(String shortForecast) {
        this.shortForecast = shortForecast;
    }

    public String getTemperatureCategory() {
        return temperatureCategory;
    }

    public void setTemperatureCategory(String temperatureCategory) {
        this.temperatureCategory = temperatureCategory;
    }
}