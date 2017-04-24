package ru.bda.weather.model.eventbus;

import ru.bda.weather.presenter.mo.WeatherTown;

public class TownWeatherEventBus {
    public final WeatherTown weatherTown;
    public TownWeatherEventBus(WeatherTown weatherTown){
        this.weatherTown = weatherTown;
    }
}
