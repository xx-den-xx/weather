package ru.bda.weather.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WeatherTownDTO implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("coord")
    @Expose
    private CoordDTO coord;
    @SerializedName("main")
    @Expose
    private MainDTO main;
    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("wind")
    @Expose
    private WindDTO wind;
    @SerializedName("sys")
    @Expose
    private SysDTO sys;
    @SerializedName("rain")
    @Expose
    private Object rain;
    @SerializedName("snow")
    @Expose
    private Object snow;
    @SerializedName("clouds")
    @Expose
    private CloudsDTO clouds;
    @SerializedName("weather")
    @Expose
    private java.util.List<WeatherDTO> weather = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoordDTO getCoord() {
        return coord;
    }

    public void setCoord(CoordDTO coord) {
        this.coord = coord;
    }

    public MainDTO getMain() {
        return main;
    }

    public void setMain(MainDTO main) {
        this.main = main;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public WindDTO getWind() {
        return wind;
    }

    public void setWind(WindDTO wind) {
        this.wind = wind;
    }

    public SysDTO getSys() {
        return sys;
    }

    public void setSys(SysDTO sys) {
        this.sys = sys;
    }

    public Object getRain() {
        return rain;
    }

    public void setRain(Object rain) {
        this.rain = rain;
    }

    public Object getSnow() {
        return snow;
    }

    public void setSnow(Object snow) {
        this.snow = snow;
    }

    public CloudsDTO getClouds() {
        return clouds;
    }

    public void setClouds(CloudsDTO clouds) {
        this.clouds = clouds;
    }

    public java.util.List<WeatherDTO> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<WeatherDTO> weather) {
        this.weather = weather;
    }
}
