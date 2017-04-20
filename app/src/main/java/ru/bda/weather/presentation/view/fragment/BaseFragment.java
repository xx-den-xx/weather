package ru.bda.weather.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    private static final AtomicInteger lastFragmentId = new AtomicInteger(0);
    private final int fragmentId;

    public BaseFragment() {
        fragmentId = lastFragmentId.incrementAndGet();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public String getFragmentName() {
        return Long.toString(fragmentId);
    }

    protected abstract void inject();
}
