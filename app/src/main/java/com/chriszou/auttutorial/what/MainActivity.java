package com.chriszou.auttutorial.what;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.chriszou.auttutorial.R;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {
    /**
     * 这里为了简单起见，直接new了一个对象，如果要做单元测试，真正实现的时候不能这么写，要用dagger2把UserModel的示例inject进来
     * 在单元测试环境下，这个对象是mock出来的。
     */
    private UserManager mUserManager = new UserManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.login).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {
        String username = ((EditText) findViewById(R.id.username)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();

        // Other code, like verify username and password

        mUserManager.login(username, password);
    }
   
    @Subscribe
    public void onLoginResult(LoginResult event) {
        //update UI accordingly
    }

}
