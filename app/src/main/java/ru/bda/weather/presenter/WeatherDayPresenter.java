package ru.bda.weather.presenter;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import ru.bda.weather.model.dto.WeatherTownDataDTO;
import ru.bda.weather.view.fragments.View;
import ru.bda.weather.view.fragments.WeatherDayView;
import rx.Observer;
import rx.Subscription;

public class WeatherDayPresenter extends BasePresenter {

    private static final String BUNDLE_WEATHER_DAY_KEY = "BUNDLE_WEATHER_DAY_KEY";

    private WeatherDayView view;

    @Inject
    public WeatherDayPresenter() {}

    public WeatherDayPresenter(WeatherDayView view) {
        this.view = view;
    }

    @Override
    protected View getView() {
        return view;
    }

    public void loadWeather(String town, String lang) {
        showLoadingState();
        Subscription subscription = model.getWeatherDay(town, "like", "metric", lang)
                .subscribe(new Observer<WeatherTownDataDTO>() {
                    @Override
                    public void onCompleted() {
                        hideLoadingState();
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoadingState();
                        showError(e);
                    }

                    @Override
                    public void onNext(WeatherTownDataDTO s) {
                        Log.d("log_weather", s.toString());
                    }
                });
        addSubscription(subscription);
    }

    public void onCreateView(Bundle savedInstanceState) {
        if (savedInstanceState != null) {

        }
    }

    public void onSaveInstanceState(Bundle outState) {

    }
}
