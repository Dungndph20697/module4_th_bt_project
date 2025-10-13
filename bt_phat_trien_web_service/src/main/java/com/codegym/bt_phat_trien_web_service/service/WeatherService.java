package com.codegym.bt_phat_trien_web_service.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {
    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getCurrentWeather(String location) throws JSONException {
        String url = "https://api.openweathermap.org/data/3.0/onecall?lat=33.44&lon=-94.04&exclude=hourly,daily&appid=" + apiKey;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            JSONObject json = new JSONObject(response.getBody());

            Map<String, Object> result = new HashMap<>();
            result.put("location", json.getString("name"));
            result.put("description", json.getJSONArray("weather")
                    .getJSONObject(0).getString("description"));
            result.put("temperature", json.getJSONObject("main").getDouble("temp"));
            result.put("humidity", json.getJSONObject("main").getInt("humidity"));
            result.put("wind_speed", json.getJSONObject("wind").getDouble("speed"));
            return result;
        }
        return Map.of("error", "Không lấy được dữ liệu thời tiết!");
    }
}
