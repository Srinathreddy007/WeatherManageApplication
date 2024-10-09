package com.WeatherManage.controller;

import com.WeatherManage.data.WeatherManageData;
import com.WeatherManage.helper.DatabaseHelper;
import com.WeatherManage.services.WeatherManagementServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//things to be added ---> windspeed from current
//                      ---> rain probabilty
//                      ---> uv index
@RestController
public class WeatherManageController {
    @Autowired
    WeatherManagementServices weatherManagementServices;
    @Autowired
    WeatherManageData weatherManageData;

  @GetMapping("/api/v1/getWeatherData/{name}")
    public ResponseEntity<?> callWeatherApi(@PathVariable String name) throws JSONException, JsonProcessingException {
      return ResponseEntity.ok(weatherManagementServices.getAllWeatherData(name));
  }
    @GetMapping("/api/v1/getAllWeatherData")
    public ResponseEntity<List<WeatherManageData>> retrieveWeatherData() {
        try {
            List<WeatherManageData> weatherDataList = DatabaseHelper.retrieveDataFromDB();
            return ResponseEntity.ok(weatherDataList);
        } catch (Exception e) {
            System.err.println("Error retrieving data: " + e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PostMapping("/api/v1/storeWeatherData")
    public ResponseEntity<?> storeWeatherData(@RequestBody String weatherData) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Deserialize JSON string to WeatherManageData object
            weatherManageData = mapper.readValue(weatherData, WeatherManageData.class);

            // Store the weather data in SQLite database
            DatabaseHelper.storeDataInSQLite(weatherManageData);

            // Return success response
            return ResponseEntity.ok("Data stored successfully");
        } catch (JsonProcessingException e) {
            System.err.println("Error parsing JSON data: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error parsing data: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error storing data: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error storing data: " + e.getMessage());
        }
    }
    @DeleteMapping("/api/v1/deleteWeatherData/{date}")
    public ResponseEntity<?> deleteWeatherDataByDate(@PathVariable String date) {
        try {
            DatabaseHelper.deleteWeatherDataByDate(date);
            return ResponseEntity.ok("Weather data deleted successfully for date: " + date+ "...");
        } catch (Exception e) {
            System.err.println("Error processing delete request: " + e.getMessage());
            return ResponseEntity.badRequest().body("Failed to delete data: " + e.getMessage());
        }
    }

}
