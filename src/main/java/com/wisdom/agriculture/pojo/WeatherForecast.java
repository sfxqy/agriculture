package com.wisdom.agriculture.pojo;

public class WeatherForecast {

    private String week;

    private String temperaturemax;

    private String temperaturemin;

    private String weather;

    private String wind;

    //温度
    private String temp;

    //湿度
    private String humidity;


    public WeatherForecast() {

    }

    public WeatherForecast(String week, String temperaturemax, String temperaturemin, String weather, String wind, String temp, String humidity) {
        this.week = week;
        this.temperaturemax = temperaturemax;
        this.temperaturemin = temperaturemin;
        this.weather = weather;
        this.wind = wind;
        this.temp = temp;
        this.humidity = humidity;
    }


    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getTemperaturemax() {
        return temperaturemax;
    }

    public void setTemperaturemax(String temperaturemax) {
        this.temperaturemax = temperaturemax;
    }

    public String getTemperaturemin() {
        return temperaturemin;
    }

    public void setTemperaturemin(String temperaturemin) {
        this.temperaturemin = temperaturemin;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "WeatherForecast{" +
                "week='" + week + '\'' +
                ", temperaturemax='" + temperaturemax + '\'' +
                ", temperaturemin='" + temperaturemin + '\'' +
                ", weather='" + weather + '\'' +
                ", wind='" + wind + '\'' +
                ", temp='" + temp + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }
}
