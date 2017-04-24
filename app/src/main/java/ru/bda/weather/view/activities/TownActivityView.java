package ru.bda.weather.view.activities;

import java.util.List;

import ru.bda.weather.presenter.mo.WeatherTown;
import ru.bda.weather.view.fragments.View;


public interface TownActivityView extends View {
    void showTowns(List<WeatherTown> weatherList);
    void startMainActivity(WeatherTown weatherTown);
    void setTownName(String town);
}
