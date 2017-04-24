package ru.bda.weather.other.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.bda.weather.model.ModelImpl;
import ru.bda.weather.presenter.BasePresenter;
import ru.bda.weather.presenter.TownActivityPresenter;
import ru.bda.weather.presenter.WeatherDayPresenter;
import ru.bda.weather.view.activities.TownActivity;
import ru.bda.weather.view.fragments.WeatherDayFragment;

@Singleton
@Component(modules = {ModelModule.class, PresenterModule.class, ViewModule.class})
public interface AppComponent {
    void inject(ModelImpl dataRepository);
    void inject(BasePresenter basePresenter);
    void inject(WeatherDayPresenter weatherDayPresenter);
    void inject(TownActivityPresenter townActivityPresenter);
    void inject(WeatherDayFragment weatherDayFragment);
    void inject(TownActivity townActivity);
}
