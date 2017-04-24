package ru.bda.weather.view.fragments;

public interface View {
    void showError(String error);
    void showLoading();
    void hideLoading();
}
