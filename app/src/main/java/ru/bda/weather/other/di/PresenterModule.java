package ru.bda.weather.other.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.bda.weather.model.Model;
import ru.bda.weather.model.ModelImpl;
import rx.subscriptions.CompositeSubscription;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    Model provideData() {
        return new ModelImpl();
    }

    @Provides
    CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }
}
