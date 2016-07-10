package com.chriszou.auttutorial.junitrule;

import android.content.Context;
import android.support.annotation.VisibleForTesting;

/**
 * Created by xiaochuang on 7/9/16.
 */
public class ContextHolder {

    private static Context sContext;

    @VisibleForTesting
    public static void set(Context context) {
        sContext = context;
    }

    public static Context get() {
        return sContext;
    }

}
