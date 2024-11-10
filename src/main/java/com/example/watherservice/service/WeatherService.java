package com.example.weatherservice.service;

import com.example.weatherservice.model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    private static final String NWS_POINTS_URL = "https://api.weather.gov/points/";
    private static final int COLD_THRESHOLD = 50; // Fahrenheit
    private static final int HOT_THRESHOLD = 80;  // Fahrenheit

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse getWeather(double lat, double lon) {
        try {
            // Step 1: Retrieve the grid data for the given coordinates
            String pointsUrl = NWS_POINTS_URL + lat + "," + lon;
            String forecastUrl = restTemplate.getForObject(pointsUrl, String.class);

            // Step 2: Fetch the forecast data
            UriComponentsBuilder forecastUriBuilder = UriComponentsBuilder.fromHttpUrl(forecastUrl);
            WeatherApiResponse forecastResponse = restTemplate.getForObject(forecastUriBuilder.toUriString(), WeatherApiResponse.class);

            // Extract today's weather information
            WeatherApiResponse.Period todayForecast = forecastResponse.getProperties().getPeriods().get(0);
            String shortForecast = todayForecast.getShortForecast();
            int temperature = todayForecast.getTemperature();

            // Determine temperature category
            String temperatureCategory = categorizeTemperature(temperature);

            // Return response object
            return new WeatherResponse(shortForecast, temperatureCategory);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch weather data", e);
        }
    }

    private String categorizeTemperature(int temperature) {
        if (temperature < COLD_THRESHOLD) return "cold";
        if (temperature > HOT_THRESHOLD) return "hot";
        return "moderate";
    }
}