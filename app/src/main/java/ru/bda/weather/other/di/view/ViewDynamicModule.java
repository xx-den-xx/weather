package ru.bda.weather.other.di.view;

import dagger.Module;
import dagger.Provides;
import ru.bda.weather.presenter.TownActivityPresenter;
import ru.bda.weather.presenter.WeatherDayPresenter;
import ru.bda.weather.view.activities.TownActivityView;
import ru.bda.weather.view.fragments.WeatherDayView;

@Module
public class ViewDynamicModule {

    private WeatherDayView weatherDayView;
    private TownActivityView townActivityView;

    public ViewDynamicModule(WeatherDayView view) {
        this.weatherDayView = view;
    }

    public  ViewDynamicModule(TownActivityView view) {
        this.townActivityView = view;
    }

    @Provides
    WeatherDayPresenter provideWeatherDayPresenter() {
        return new WeatherDayPresenter(weatherDayView);
    }

    @Provides
    TownActivityPresenter provideTownActivityPresenter() {
        return new TownActivityPresenter(townActivityView);
    }
}
