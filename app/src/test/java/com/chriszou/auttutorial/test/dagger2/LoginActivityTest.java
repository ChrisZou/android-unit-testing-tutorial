package com.chriszou.auttutorial.test.dagger2;

import android.widget.EditText;

import com.chriszou.auttutorial.BuildConfig;
import com.chriszou.auttutorial.R;
import com.chriszou.auttutorial.dagger2.LoginActivity;
import com.chriszou.auttutorial.dagger2.LoginPresenter;
import com.chriszou.auttutorial.dagger2.UserManager;
import com.chriszou.auttutorial.mockito.PasswordValidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by xiaochuang on 5/14/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginActivityTest {

    @Test
    public void testActivityStart() {
        TestUtils.setupDagger();
        LoginPresenter mockLoginPresenter = mock(LoginPresenter.class);
        Mockito.when(TestUtils.appModule.provideLoginPresenter(any(UserManager.class), any(PasswordValidator.class))).thenReturn(mockLoginPresenter);

        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        ((EditText) loginActivity.findViewById(R.id.username)).setText("xiaochuang");
        ((EditText) loginActivity.findViewById(R.id.password)).setText("xiaochuang is handsome");
        loginActivity.findViewById(R.id.login).performClick();

        verify(mockLoginPresenter).login("xiaochuang", "xiaochuang is handsome");
    }
}