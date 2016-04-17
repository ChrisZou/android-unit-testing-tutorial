package com.chriszou.auttutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        loadUsers();
    }

//    public void loadUsers() {
//        mUserModel.getUsers(new Callback() {
//            public void onUserLoaded(List<User> users) {
//                //some action performed to users, like sort, filter, etc
//                //...
//                updateUsers(users);
//            }
//        });
//    }

//    public interface Callback {
//        public void onUserLoaded(List<User> users);
//    }

}
