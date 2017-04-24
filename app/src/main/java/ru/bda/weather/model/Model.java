package ru.bda.weather.model;

import ru.bda.weather.model.dto.WeatherTownDataDTO;
import rx.Observable;

public interface Model {
    Observable<WeatherTownDataDTO> getWeatherDay(String city, String type, String units, String lang);
}
