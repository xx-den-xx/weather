package ru.bda.weather.other;

import android.support.multidex.MultiDexApplication;

import ru.bda.weather.other.di.AppComponent;
import ru.bda.weather.other.di.DaggerAppComponent;

public class App extends MultiDexApplication {

    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder().build();
    }
}
