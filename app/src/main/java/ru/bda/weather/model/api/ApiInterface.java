package ru.bda.weather.model.api;


import retrofit2.http.GET;
import rx.Observable;

public interface ApiInterface {

    @GET("")
    Observable<String> getWeather();
}
