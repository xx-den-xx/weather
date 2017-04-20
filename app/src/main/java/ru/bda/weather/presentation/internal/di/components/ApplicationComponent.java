package ru.bda.weather.presentation.internal.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ru.bda.weather.domain.executor.PostExecutionThread;
import ru.bda.weather.domain.executor.ThreadExecutor;
import ru.bda.weather.presentation.internal.di.modules.ApplicationModule;
import ru.bda.weather.presentation.view.activity.BaseActivity;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();

}
