package ru.bda.weather;

import android.app.Application;

import ru.bda.weather.presentation.internal.di.components.ApplicationComponent;
import ru.bda.weather.presentation.internal.di.components.DaggerApplicationComponent;
import ru.bda.weather.presentation.internal.di.modules.ApplicationModule;


public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
