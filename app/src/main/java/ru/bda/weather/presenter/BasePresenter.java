package ru.bda.weather.presenter;

import javax.inject.Inject;

import ru.bda.weather.model.Model;
import ru.bda.weather.other.App;
import ru.bda.weather.view.fragments.View;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter implements Presenter{

    @Inject
    protected Model model;

    @Inject
    protected CompositeSubscription compositeSubscription;

    public BasePresenter() {
        App.getComponent().inject(this);
    }

    protected void addSubscription(Subscription subscription) {
        compositeSubscription.add(subscription);
    }

    protected abstract View getView();

    protected void showLoadingState() {
        getView().showLoading();
    }

    protected void hideLoadingState() {
        getView().hideLoading();
    }

    protected void showError(Throwable e) {
        getView().showError(e.getMessage());
    }

    @Override
    public void onStop() {
        compositeSubscription.clear();
    }
}
