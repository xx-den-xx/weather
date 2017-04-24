package ru.bda.weather.presenter.mo;

import java.io.Serializable;

import ru.bda.weather.model.dto.WeatherTownDTO;
import ru.bda.weather.other.Const;

public class WeatherTown implements Serializable{

    private int id;
    private String name;
    private double coordLat;
    private double coordLon;
    private double mainTemp;
    private double mainTempMin;
    private double mainTempMax;
    private double mainPressure;
    private int mainHumidity;
    private double mainSeaLevel;
    private double mainGrndLevel;
    private int dt;
    private double windSpeed;
    private double windDeg;
    private String sysCountry;
    private int cloudsAll;
    private int weatherId;
    private String weatherMain;
    private String weatherDescription;
    private String weatherIcon;

    public WeatherTown(WeatherTownDTO weather) {
        this.id = weather.getId();
        this.name = weather.getName();
        this.coordLat = weather.getCoord().getLat();
        this.coordLon = weather.getCoord().getLon();
        this.mainTemp = weather.getMain().getTemp();
        this.mainTempMin = weather.getMain().getTempMin();
        this.mainTempMax = weather.getMain().getTempMax();
        this.mainPressure = weather.getMain().getPressure();
        this.mainHumidity = weather.getMain().getHumidity();
        this.mainSeaLevel = weather.getMain().getSeaLevel();
        this.mainGrndLevel = weather.getMain().getGrndLevel();
        this.dt = weather.getDt();
        this.windSpeed = weather.getWind().getSpeed();
        this.windDeg = weather.getWind().getDeg();
        this.sysCountry = weather.getSys().getCountry();
        this.cloudsAll = weather.getClouds().getAll();
        this.weatherId = weather.getWeather().get(0).getId();
        this.weatherMain = weather.getWeather().get(0).getMain();
        this.weatherDescription = weather.getWeather().get(0).getDescription();
        this.weatherIcon = Const.WEATHER_ICON_URL + weather.getWeather().get(0).getIcon() + ".png";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCoordLat() {
        return coordLat;
    }

    public void setCoordLat(double coordLat) {
        this.coordLat = coordLat;
    }

    public double getCoordLon() {
        return coordLon;
    }

    public void setCoordLon(double coordLon) {
        this.coordLon = coordLon;
    }

    public double getMainTemp() {
        return mainTemp;
    }

    public void setMainTemp(double mainTemp) {
        this.mainTemp = mainTemp;
    }

    public double getMainTempMin() {
        return mainTempMin;
    }

    public void setMainTempMin(double mainTempMin) {
        this.mainTempMin = mainTempMin;
    }

    public double getMainTempMax() {
        return mainTempMax;
    }

    public void setMainTempMax(double mainTempMax) {
        this.mainTempMax = mainTempMax;
    }

    public double getMainPressure() {
        return mainPressure;
    }

    public void setMainPressure(double mainPressure) {
        this.mainPressure = mainPressure;
    }

    public int getMainHumidity() {
        return mainHumidity;
    }

    public void setMainHumidity(int mainHumidity) {
        this.mainHumidity = mainHumidity;
    }

    public double getMainSeaLevel() {
        return mainSeaLevel;
    }

    public void setMainSeaLevel(double mainSeaLevel) {
        this.mainSeaLevel = mainSeaLevel;
    }

    public double getMainGrndLevel() {
        return mainGrndLevel;
    }

    public void setMainGrndLevel(double mainGrndLevel) {
        this.mainGrndLevel = mainGrndLevel;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(double windDeg) {
        this.windDeg = windDeg;
    }

    public String getSysCountry() {
        return sysCountry;
    }

    public void setSysCountry(String sysCountry) {
        this.sysCountry = sysCountry;
    }

    public int getCloudsAll() {
        return cloudsAll;
    }

    public void setCloudsAll(int cloudsAll) {
        this.cloudsAll = cloudsAll;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    @Override
    public String toString() {
        return "WeatherTown{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordLat=" + coordLat +
                ", coordLon=" + coordLon +
                ", mainTemp=" + mainTemp +
                ", mainTempMin=" + mainTempMin +
                ", mainTempMax=" + mainTempMax +
                ", mainPressure=" + mainPressure +
                ", mainHumidity=" + mainHumidity +
                ", mainSeaLevel=" + mainSeaLevel +
                ", mainGrndLevel=" + mainGrndLevel +
                ", dt=" + dt +
                ", windSpeed=" + windSpeed +
                ", windDeg=" + windDeg +
                ", sysCountry='" + sysCountry + '\'' +
                ", cloudsAll=" + cloudsAll +
                ", weatherId=" + weatherId +
                ", weatherMain='" + weatherMain + '\'' +
                ", weatherDescription='" + weatherDescription + '\'' +
                ", weatherIcon='" + weatherIcon + '\'' +
                '}';
    }
}
