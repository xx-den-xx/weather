package ru.bda.weather.presenter.mapper;

import java.util.List;

import javax.inject.Inject;

import ru.bda.weather.model.dto.WeatherTownDataDTO;
import ru.bda.weather.presenter.mo.WeatherTown;
import rx.Observable;
import rx.functions.Func1;

/**
 * email: denbelobaba@gmail.com
 *
 * @author Belobaba Denis
 */

public class TownWeatherMapper implements Func1<WeatherTownDataDTO, List<WeatherTown>> {

    @Inject
    public TownWeatherMapper() {}

    @Override
    public List<WeatherTown> call(WeatherTownDataDTO dataDTO) {
        if (dataDTO == null)
            return null;

        List<WeatherTown> weatherTownList = Observable.from(dataDTO.getList())
                .map(townDTO -> new WeatherTown(townDTO))
                .toList()
                .toBlocking()
                .first();
        return weatherTownList;
    }
}
