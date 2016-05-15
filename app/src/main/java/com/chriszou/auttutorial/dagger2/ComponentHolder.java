package com.chriszou.auttutorial.dagger2;

/**
 * Created by xiaochuang on 5/14/16.
 */
public class ComponentHolder {
    private static AppComponent sAppComponent;

    public static void setAppComponent(AppComponent appComponent) {
        sAppComponent = appComponent;
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

}
