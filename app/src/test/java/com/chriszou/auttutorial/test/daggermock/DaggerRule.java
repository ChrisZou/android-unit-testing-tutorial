package com.chriszou.auttutorial.test.daggermock;

import com.chriszou.auttutorial.dagger2.AppComponent;
import com.chriszou.auttutorial.dagger2.AppModule;
import com.chriszou.auttutorial.dagger2.ComponentHolder;

import org.robolectric.RuntimeEnvironment;

import it.cosenonjaviste.daggermock.DaggerMockRule;

/**
 * Created by xiaochuang on 7/24/16.
 */
public class DaggerRule extends DaggerMockRule<AppComponent> {
    public DaggerRule() {
        super(AppComponent.class, new AppModule(RuntimeEnvironment.application));
        set(new ComponentSetter<AppComponent>() {
            @Override
            public void setComponent(AppComponent appComponent) {
                ComponentHolder.setAppComponent(appComponent);
            }
        });
    }
}
