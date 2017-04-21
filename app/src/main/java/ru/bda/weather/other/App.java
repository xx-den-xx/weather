package ru.bda.weather.other;

import android.app.Application;

import ru.bda.weather.other.di.AppComponent;

public class App extends Application {

    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
