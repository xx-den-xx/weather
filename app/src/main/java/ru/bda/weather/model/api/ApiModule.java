package ru.bda.weather.model.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.bda.weather.BuildConfig;
import ru.bda.weather.other.Const;

public class ApiModule {
    private static final boolean ENABLE_LOG = true;

    private static final boolean ENABLE_AUTH = false;
    private static final String AUTH_64 = "***";

    private ApiModule() {}

    public static ApiInterface getApiInterface(String url) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel((BuildConfig.DEBUG) ? HttpLoggingInterceptor.Level.BODY
                                : HttpLoggingInterceptor.Level.NONE))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(ApiInterface.class);
    }
}
