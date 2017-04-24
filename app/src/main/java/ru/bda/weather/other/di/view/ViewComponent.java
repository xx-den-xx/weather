package ru.bda.weather.other.di.view;

import javax.inject.Singleton;

import dagger.Component;
import ru.bda.weather.view.activities.TownActivity;
import ru.bda.weather.view.fragments.WeatherDayFragment;

@Singleton
@Component(modules = {ViewDynamicModule.class})
public interface ViewComponent {

    void inject(WeatherDayFragment fragment);

    void inject(TownActivity activity);
}
