package com.example.net.rxjava;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BllOvserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(@NotNull Disposable d) {

    }

    @Override
    public void onNext(@NotNull T t) {

    }

    @Override
    public void onError(@NotNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
