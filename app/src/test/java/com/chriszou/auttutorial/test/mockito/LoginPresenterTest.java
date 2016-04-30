package com.chriszou.auttutorial.test.mockito;

import com.chriszou.auttutorial.groupshare.NetworkCallback;
import com.chriszou.auttutorial.mockito.LoginPresenter;
import com.chriszou.auttutorial.mockito.PasswordValidator;
import com.chriszou.auttutorial.test.groupshare.JSpec;
import com.chriszou.auttutorial.what.UserManager;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

/**
 * Created by xiaochuang on 4/29/16.
 */
public class LoginPresenterTest {

    @Test
    public void testLogin() {
        UserManager mockUserManager = Mockito.mock(UserManager.class);
        LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.setUserManager(mockUserManager);

        loginPresenter.login("xiaochuang", "xiaochuang password");

        Mockito.verify(mockUserManager).performLogin(anyString(), anyString());

    }

    @Test
    @JSpec(desc = "should mock return given value")
    public void test() {
        PasswordValidator validator = Mockito.mock(PasswordValidator.class);
        Mockito.when(validator.verifyPassword("xiaochuangishandsome")).thenReturn(true);
        Assert.assertEquals(true, validator.verifyPassword("xiaochuangishandsome"));

        Mockito.when(validator.verifyPassword(anyString())).thenReturn(true);
        Assert.assertEquals(true, validator.verifyPassword("xiaochuangishandsome11"));

    }

    @Test
    @JSpec(desc = "should mock perform certain action")
    public void testMockAnswer() {
        UserManager mockUserManager = Mockito.mock(UserManager.class);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                //这里可以获得传给performLogin的参数
                Object[] arguments = invocation.getArguments();

                NetworkCallback callback = (NetworkCallback) arguments[2];
                callback.onFailure(500, "Server error");
                return 500; //对于如果mock的是非void方法来说，这个将作为目标方法的返回值
            }
        }).when(mockUserManager).performLogin(anyString(), anyString(), any(NetworkCallback.class));


        mockUserManager.performLogin("xiaochuang", "xiaochuang password", Mockito.mock(NetworkCallback.class));
        //
    }

    @Test
    public void testSpy() {
        //跟创建mock类似，只不过调用的是spy方法，而不是mock方法。spy的用法
        PasswordValidator spyValidator = Mockito.spy(PasswordValidator.class);

        //在默认情况下，spy对象会调用这个类的real implementation，并返回相应的返回值
        spyValidator.verifyPassword("xiaochuang_is_handsome"); //true
        spyValidator.verifyPassword("xiaochuang_is_not_handsome"); //false

        Mockito.when(spyValidator.verifyPassword(anyString())).thenReturn(true);

        spyValidator.verifyPassword("xiaochuang_is_handsome");
        Mockito.verify(spyValidator).verifyPassword("xiaochuang_is_handsome");

    }
}