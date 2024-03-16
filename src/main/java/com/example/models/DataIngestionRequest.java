package com.example.models;

public class DataIngestionRequest {
    private WeatherData weatherData;
    private SatelliteImagery satelliteImagery;
    private SocialMediaFeed socialMediaFeeds;

    // Getters and setters

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public SatelliteImagery getSatelliteImagery() {
        return satelliteImagery;
    }

    public SocialMediaFeed getSocialMediaFeeds() {
        return socialMediaFeeds;
    }
}