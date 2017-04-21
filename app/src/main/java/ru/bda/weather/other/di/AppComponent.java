package ru.bda.weather.other.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.bda.weather.model.ModelImpl;

@Singleton
@Component(modules = {ModelModule.class, PresenterModule.class, ViewModule.class})
public interface AppComponent {
    void inject(ModelImpl dataRepository);
}
