package ru.bda.weather.view;

public interface ActivityCallback {

    void showError(String error);

    void showProgressBar();

    void hideProgressBar();

    void onFabClick();
}
