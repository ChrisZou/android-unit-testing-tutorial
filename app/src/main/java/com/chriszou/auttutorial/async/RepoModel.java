package com.chriszou.auttutorial.async;


import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiaochuang on 8/6/16.
 */
public class RepoModel {
    private Handler mUiHandler = new Handler(Looper.getMainLooper());

    public RepoModel() {
    }

    public Observable<List<Repo>> loadRepos() {
        return Observable.create(new OnSubscribe<List<Repo>>() {
            @Override
            public void call(Subscriber<? super List<Repo>> subscriber) {
                try {
                    //Imagine you're getting repos from network or database
                    Thread.sleep(2000);
                    final List<Repo> repos = new ArrayList<>();
                    repos.add(new Repo("android-unit-testing-tutorial", "A repo that demos how to do android unit testing"));
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(repos);
                        subscriber.onCompleted();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onError(e);
                    }
                }

            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public void loadRepos(final RepoCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Imagine you're getting repos from network or database
                    Thread.sleep(1000);
                    final List<Repo> repos = new ArrayList<>();
                    repos.add(new Repo("android-unit-testing-tutorial", "A repo that demos how to do android unit testing"));
                    mUiHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(repos);
                        }
                    });
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                    mUiHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailure(500, e.getMessage());
                        }
                    });
                }
            }
        }).start();


    }

    interface RepoCallback {
        void onSuccess(List<Repo> repos);

        void onFailure(int code, String msg);
    }
}
