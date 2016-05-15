package com.chriszou.auttutorial.test.dagger2;

import com.chriszou.auttutorial.dagger2.AppComponent;
import com.chriszou.auttutorial.dagger2.AppModule;
import com.chriszou.auttutorial.dagger2.ComponentHolder;
import com.chriszou.auttutorial.dagger2.DaggerAppComponent;

import org.robolectric.RuntimeEnvironment;

import static org.mockito.Mockito.spy;

/**
 * Created by xiaochuang on 5/15/16.
 */
public class TestUtils {
    public static final AppModule appModule = spy(new AppModule(RuntimeEnvironment.application));

    public static void setupDagger() {
        AppComponent appComponent = DaggerAppComponent.builder().appModule(appModule).build();
        ComponentHolder.setAppComponent(appComponent);
    }

}
