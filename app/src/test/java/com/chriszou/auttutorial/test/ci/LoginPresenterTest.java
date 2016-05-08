package com.chriszou.auttutorial.test.ci;

import com.chriszou.auttutorial.di.LoginPresenter;
import com.chriszou.auttutorial.what.UserManager;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by xiaochuang on 5/7/16.
 */
public class LoginPresenterTest {

    @Test
    public void testLogin() {
        UserManager mockUserManager = Mockito.mock(UserManager.class);
        LoginPresenter presenter = new LoginPresenter(mockUserManager);

        presenter.login("xiaochuang", "xiaochuang password");

        Mockito.verify(mockUserManager).performLogin("xiaochuang", "xiaochuang password");
    }
}
