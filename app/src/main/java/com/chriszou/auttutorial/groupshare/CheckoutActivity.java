package com.chriszou.auttutorial.groupshare;

import android.app.Activity;
import android.os.Bundle;

import com.chriszou.auttutorial.R;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

/**
 * Created by xiaochuang on 4/25/16.
 */
public class CheckoutActivity extends Activity {

    /**
     * 这个是使用dagger2的方式，在测试环境下，这个mCheckoutModel会换成mock
     */
    @Inject
    CheckoutModel mCheckoutModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_activity);

        String paymentId = "some paymentId"; //这个是从外面传进来的

        mCheckoutModel = new CheckoutModel(new PaymentApi(), new Bus()); //假设这里是使用Dagger2注入进来的，具体这种怎么实现，请参考后续文章。
        mCheckoutModel.loadCheckoutData(paymentId);
    }

    @Subscribe
    public void onDataLoadedEvent(DataLoadedEvent event) {
        if (event.successful()) {
            //Update UI
        } else {
            //show error message
        }
    }
}
