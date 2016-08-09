package com.chriszou.auttutorial.async;

import com.chriszou.auttutorial.BuildConfig;
import com.chriszou.auttutorial.async.RepoModel.RepoCallback;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.functions.Action1;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by xiaochuang on 8/7/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RepoModelTest {

    @Test
    public void testLoadRepos() throws Exception {
        RepoModel model = new RepoModel();
        final List<Repo> result = new ArrayList<>();
        final CountDownLatch latch = new CountDownLatch(1);
        model.loadRepos(new RepoCallback() {
            @Override
            public void onSuccess(List<Repo> repos) {
                result.addAll(repos);
                latch.countDown();
            }

            @Override
            public void onFailure(int code, String msg) {
                fail();
            }
        });
        latch.await();
        assertEquals(1, result.size());
        latch.await(2, TimeUnit.SECONDS);
    }

    @Test
    public void testLoadReposInRx() {
        RxJavaPlugins.getInstance().registerSchedulersHook(new RxJavaSchedulersHook() {
            @Override
            public Scheduler getIOScheduler() {
                return Schedulers.immediate();
            }
        });
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });
        RepoModel model = new RepoModel();
        final List<Repo> result = new ArrayList<>();
        model.loadRepos().subscribe(new Action1<List<Repo>>() {
            @Override
            public void call(List<Repo> repos) {
                result.addAll(repos);
            }
        });
        assertEquals(1, result.size());
    }
}