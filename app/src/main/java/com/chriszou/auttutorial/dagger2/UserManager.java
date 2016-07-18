package com.chriszou.auttutorial.dagger2;

import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by xiaochuang on 5/10/16.
 */
public class UserManager {
    private final SharedPreferences mPref;
    private final UserApiService mRestAdapter;

    @Inject
    public UserManager(SharedPreferences preferences, UserApiService userApiService) {
        this.mPref = preferences;
        this.mRestAdapter = userApiService;
    }

    public void performLogin(String username, String password) {
    }

    public void performRegister(String username, String password) {
    }
}
