package com.chriszou.auttutorial.mockito;

/**
 * Created by xiaochuang on 4/30/16.
 */
public class PasswordValidator {
    public boolean verifyPassword(String password) {
        //假设这个方法需要联网
        return "xiaochuang_is_handsome".equals(password);
    }
}
