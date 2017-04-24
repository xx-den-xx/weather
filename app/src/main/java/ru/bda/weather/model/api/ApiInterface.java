package ru.bda.weather.model.api;


import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.bda.weather.model.dto.WeatherTownDataDTO;
import rx.Observable;

public interface ApiInterface {

    @GET("find")
    Observable<WeatherTownDataDTO> getWeatherDay(@Query("q") String city,
                                                 @Query("type") String type,
                                                 @Query("units") String units,
                                                 @Query("lang") String lang,
                                                 @Query("APPID") String appid);
}
