package com.chriszou.auttutorial.groupshare;

import com.squareup.otto.Bus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaochuang on 4/25/16.
 */
public class CheckoutModel {

    private final PaymentApi mApi;
    private final Bus mBus;

    public CheckoutModel(PaymentApi api, Bus bus) {
        this.mApi = api;
        this.mBus = bus;
    }

    public void loadCheckoutData(String paymentId) {

        //Other code, like composing params

        String someUrl = "some url";
        Map<String, String> someParams = new HashMap<>();
        mApi.get(someUrl, someParams, new NetworkCallback() {
            @Override
            public void onSuccess(Object data) {
                mBus.post(new DataLoadedEvent(data));
            }

            @Override
            public void onFailure(int code, String msg) {
                mBus.post(new DataLoadedEvent(code, msg));
            }
        });
    }
}
