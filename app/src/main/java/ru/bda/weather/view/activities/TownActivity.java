package ru.bda.weather.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.bda.weather.R;
import ru.bda.weather.model.dto.WeatherTownDTO;
import ru.bda.weather.model.eventbus.TownWeatherEventBus;
import ru.bda.weather.other.di.view.DaggerViewComponent;
import ru.bda.weather.other.di.view.ViewComponent;
import ru.bda.weather.other.di.view.ViewDynamicModule;
import ru.bda.weather.presenter.TownActivityPresenter;
import ru.bda.weather.presenter.mo.WeatherTown;
import ru.bda.weather.view.adapters.TownRecyclerAdapter;

public class TownActivity extends AppCompatActivity implements TownActivityView{

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.toolbar_progress_bar)
    ProgressBar progressBar;

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Bind(R.id.edit_text)
    EditText editText;

    @Inject
    protected TownActivityPresenter presenter;

    private ViewComponent viewComponent;

    private TownRecyclerAdapter adapter;
    private LinearLayoutManager manager;
    private List<WeatherTown> weatherList = new ArrayList<>();
    private String town = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (viewComponent == null) {
            viewComponent = DaggerViewComponent.builder()
                    .viewDynamicModule(new ViewDynamicModule(this))
                    .build();
        }
        viewComponent.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                town = s.toString();
                if (s.length() > 2) {
                    presenter.loadTown(town, "ru");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        presenter.onCreate(savedInstanceState);
        setRecyclerView();
    }

    private void setRecyclerView() {
        adapter = new TownRecyclerAdapter(weatherList, presenter, this);
        manager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
    }

    public void setViewComponent(ViewComponent viewComponent) {
        this.viewComponent = viewComponent;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void showError(String error) {
        Snackbar.make(progressBar, error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showTowns(List<WeatherTown> list) {
        adapter.setWeatherList(list);
    }

    @Override
    public void startMainActivity(WeatherTown weatherTown) {
        EventBus.getDefault().postSticky(new TownWeatherEventBus(weatherTown));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void setTownName(String town) {
        this.town = town;
        editText.setText(town);
    }
}
