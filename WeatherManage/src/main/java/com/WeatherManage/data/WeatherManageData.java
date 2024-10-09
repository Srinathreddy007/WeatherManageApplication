package com.WeatherManage.data;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class WeatherManageData {
    private String date;
    private String sunrise;
    private String timezone;
    private String temperature_max;
    private String timezone_abbreviation;
    private String weathercode;
    private String temperature_min;
    private String sunset;
    private String temperature;
    private String apparent_temperature;
    private String humidity;
    private String time;
    private String uvIndex;

    public WeatherManageData() {
    }

    public WeatherManageData(String date, String sunrise, String timezone, String temperature_max, String timezone_abbreviation, String weathercode, String temperature_min, String sunset, String temperature, String apparent_temperature, String humidity, String time, String uvIndex) {
        this.date = date;
        this.sunrise = sunrise;
        this.timezone = timezone;
        this.temperature_max = temperature_max;
        this.timezone_abbreviation = timezone_abbreviation;
        this.weathercode = weathercode;
        this.temperature_min = temperature_min;
        this.sunset = sunset;
        this.temperature = temperature;
        this.apparent_temperature = apparent_temperature;
        this.humidity = humidity;
        this.time = time;
        this.uvIndex = uvIndex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTemperature_max() {
        return temperature_max;
    }

    public void setTemperature_max(String temperature_max) {
        this.temperature_max = temperature_max;
    }

    public String getTimezone_abbreviation() {
        return timezone_abbreviation;
    }

    public void setTimezone_abbreviation(String timezone_abbreviation) {
        this.timezone_abbreviation = timezone_abbreviation;
    }

    public String getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(String weathercode) {
        this.weathercode = weathercode;
    }

    public String getTemperature_min() {
        return temperature_min;
    }

    public void setTemperature_min(String temperature_min) {
        this.temperature_min = temperature_min;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getApparent_temperature() {
        return apparent_temperature;
    }

    public void setApparent_temperature(String apparent_temperature) {
        this.apparent_temperature = apparent_temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUvIndex() {
        return uvIndex;
    }


    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

}
