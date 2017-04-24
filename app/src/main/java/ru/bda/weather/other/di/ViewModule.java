package ru.bda.weather.other.di;

import dagger.Module;
import dagger.Provides;
import ru.bda.weather.presenter.TownActivityPresenter;
import ru.bda.weather.presenter.WeatherDayPresenter;

@Module
public class ViewModule {

    @Provides
    TownActivityPresenter provideTownActivityPresenter() {
        return new TownActivityPresenter();
    }

    @Provides
    WeatherDayPresenter provideWeatherDayPresenter() {
        return new WeatherDayPresenter();
    }
}
