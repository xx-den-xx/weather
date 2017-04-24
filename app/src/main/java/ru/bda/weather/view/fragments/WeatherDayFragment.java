package ru.bda.weather.view.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.*;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import ru.bda.weather.R;
import ru.bda.weather.other.di.view.DaggerViewComponent;
import ru.bda.weather.other.di.view.ViewComponent;
import ru.bda.weather.other.di.view.ViewDynamicModule;
import ru.bda.weather.presenter.BasePresenter;
import ru.bda.weather.presenter.WeatherDayPresenter;
import ru.bda.weather.view.ActivityCallback;

public class WeatherDayFragment extends BaseFragment implements WeatherDayView{

    @Inject
    protected WeatherDayPresenter presenter;

    private ActivityCallback activityCallback;

    private ViewComponent viewComponent;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCallback = (ActivityCallback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement activityCallback");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (viewComponent == null) {
            viewComponent = DaggerViewComponent.builder()
                    .viewDynamicModule(new ViewDynamicModule(this))
                    .build();
        }
        viewComponent.inject(this);
        super.onCreate(savedInstanceState);
    }

    public void setViewComponent(ViewComponent viewComponent) {
        this.viewComponent = viewComponent;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_day, container, false);
        ButterKnife.bind(this, view);
        presenter.onCreateView(savedInstanceState);
        presenter.loadWeather("Moscow", "ru");
        return view;
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void showWeatherDay() {

    }


}
