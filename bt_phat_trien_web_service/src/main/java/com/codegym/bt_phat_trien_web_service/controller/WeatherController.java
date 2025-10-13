package com.codegym.bt_phat_trien_web_service.controller;

import com.codegym.bt_phat_trien_web_service.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/{username}/{password}/{location}")
    public ResponseEntity<?> getWeather(
            @PathVariable String username,
            @PathVariable String password,
            @PathVariable String location) {

        // Xác thực thủ công
        if (!(username.equals("admin") && password.equals("123")) &&
                !(username.equals("user") && password.equals("456"))) {
            return ResponseEntity.status(401).body("Sai thông tin xác thực!");
        }

        try {
            var result = service.getCurrentWeather(location);
            if (result.containsKey("error")) {
                return ResponseEntity.badRequest().body(result);
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Không tìm thấy địa phương hoặc lỗi khi gọi API!");
        }
    }
}
