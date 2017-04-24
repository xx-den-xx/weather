package ru.bda.weather.model;

import javax.inject.Inject;
import javax.inject.Named;

import ru.bda.weather.model.api.ApiInterface;
import ru.bda.weather.model.dto.WeatherTownDataDTO;
import ru.bda.weather.other.App;
import ru.bda.weather.other.Const;
import rx.Observable;
import rx.Scheduler;

/**
 * Created by User on 21.04.2017.
 */

public class ModelImpl implements Model {

    private final Observable.Transformer schedulersTransformer;

    @Inject
    protected ApiInterface apiInterface;

    @Inject
    @Named(Const.UI_THREAD)
    Scheduler uiThread;

    @Inject
    @Named(Const.IO_THREAD)
    Scheduler ioThread;

    public ModelImpl() {
        App.getComponent().inject(this);
        schedulersTransformer = o -> ((Observable)o).subscribeOn(ioThread)
                .observeOn(uiThread)
                .unsubscribeOn(ioThread);
    }

    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applySchedulers() {
        return (Observable.Transformer<T, T>) schedulersTransformer;
    }

    @Override
    public Observable<WeatherTownDataDTO> getWeatherDay(String city, String type, String units, String lang) {
        return apiInterface.getWeatherDay(city, type,  units, lang, Const.API_KEY)
                .compose(applySchedulers());
    }
}
