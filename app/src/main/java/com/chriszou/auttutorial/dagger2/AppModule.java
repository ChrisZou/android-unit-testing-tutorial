package com.chriszou.auttutorial.dagger2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.chriszou.auttutorial.mockito.PasswordValidator;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by xiaochuang on 5/11/16.
 */
@Module
public class AppModule {

    private final Context mContext;

    public AppModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient okhttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
        return okhttpClient;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okhttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okhttpClient)
                .baseUrl("https://api.github.com")
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    public UserApiService provideUserApiService(Retrofit retrofit) {
        return retrofit.create(UserApiService.class);
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    public UserManager provideUserManager(SharedPreferences preferences, UserApiService service) {
        return new UserManager(preferences, service);
    }

    @Provides
    public PasswordValidator providePasswordValidator() {
        return new PasswordValidator();
    }

    @Provides
    public LoginPresenter provideLoginPresenter(UserManager userManager, PasswordValidator validator) {
        return new LoginPresenter(userManager, validator);
    }

    @Provides
    public Context provideContext() {
        return mContext;
    }


}
