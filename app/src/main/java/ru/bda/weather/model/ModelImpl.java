package ru.bda.weather.model;

import javax.inject.Inject;
import javax.inject.Named;

import ru.bda.weather.model.api.ApiInterface;
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
    protected ApiInterface apiIntrface;

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

}
