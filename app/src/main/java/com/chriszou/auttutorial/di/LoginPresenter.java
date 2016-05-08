package com.chriszou.auttutorial.di;

import com.chriszou.auttutorial.what.UserManager;

/**
 * Created by xiaochuang on 4/29/16.
 */
public class LoginPresenter {

    private UserManager mUserManager = new UserManager();

    public LoginPresenter(UserManager userManager) {
        this.mUserManager = userManager;
    }

    public void login(String username, String password) {
        if (username == null || username.length() == 0) return;
        if (password == null || password.length() < 6) return;

        mUserManager.performLogin(username, password);
    }


    /**
     * 通过方法参数来做DI的例子（Argument Injection）
     */
    public void login(UserManager userManager, String username, String password) {
        if (username == null || username.length() == 0) return;
        if (password == null || password.length() < 6) return;

        userManager.performLogin(username, password);
    }

}
