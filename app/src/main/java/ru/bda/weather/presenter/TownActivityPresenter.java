package ru.bda.weather.presenter;

import android.os.Bundle;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ru.bda.weather.presenter.mapper.TownWeatherMapper;
import ru.bda.weather.presenter.mo.WeatherTown;
import ru.bda.weather.view.activities.TownActivityView;
import ru.bda.weather.view.fragments.View;
import rx.Observer;
import rx.Subscription;

public class TownActivityPresenter extends BasePresenter {

    private static final String BUNDLE_LIST_WEATHER = "weather";
    private static final String BUNDLE_TOWN = "town";

    @Inject
    protected TownWeatherMapper townWeatherMapper;
    private TownActivityView view;
    private String town;
    private List<WeatherTown> weatherList;

    @Inject
    public TownActivityPresenter() {

    }

    public TownActivityPresenter(TownActivityView view) {
        this.view = view;
    }

    @Override
    protected View getView() {
        return view;
    }

    public void loadTown(String town, String lang) {
        this.town = town;
        onStop();
        showLoadingState();
        Subscription subscription = model.getWeatherDay(town, "like", "metric", lang)
                .map(townWeatherMapper)
                .subscribe(new Observer<List<WeatherTown>>() {
                    @Override
                    public void onCompleted() {
                        hideLoadingState();
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoadingState();
                        Log.e("log_town", e.getLocalizedMessage());
                        showError(e);
                    }

                    @Override
                    public void onNext(List<WeatherTown> list) {
                        if (list != null && !list.isEmpty()) {
                            weatherList = list;
                            view.showTowns(list);
                        }
                        view.showTowns(list);
                        Log.d("log_weather", "load data!!!!");
                    }
                });
        addSubscription(subscription);
    }

    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            weatherList = (List<WeatherTown>) savedInstanceState.getSerializable(BUNDLE_LIST_WEATHER);
            town = savedInstanceState.getString(BUNDLE_TOWN);
            view.setTownName(town);
        }
        if (isWeatherListNotEmpty()) {
            view.showTowns(weatherList);
        }
    }

    private boolean isWeatherListNotEmpty() {
        return (weatherList != null && !weatherList.isEmpty());
    }

    public void onSaveInstanceState(Bundle outState) {
        if (isWeatherListNotEmpty()) outState.putSerializable(BUNDLE_LIST_WEATHER, new ArrayList<>(weatherList));
    }

    public void clickRepo(WeatherTown weatherTown) {
        view.startMainActivity(weatherTown);
    }
}
