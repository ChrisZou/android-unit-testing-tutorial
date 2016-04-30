package com.chriszou.auttutorial.test.groupshare;

import com.chriszou.auttutorial.groupshare.CheckoutModel;
import com.chriszou.auttutorial.groupshare.NetworkCallback;
import com.chriszou.auttutorial.groupshare.PaymentApi;
import com.chriszou.auttutorial.test.groupshare.JSpec;
import com.squareup.otto.Bus;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.HashMap;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;

/**
 * Created by xiaochuang on 4/25/16.
 */
public class CheckoutModelTest {

    private CheckoutModel model;
    private PaymentApi paymentApi;
    private Bus bus;

    @Before
    public void setup() {
        paymentApi = mock(PaymentApi.class);
        bus = mock(Bus.class);
        model = new CheckoutModel(paymentApi, bus);
    }

    @Test
    @JSpec(desc = "should loadCheckoutData call Api.get")
    public void testLoadCheckoutData() {
        model.loadCheckoutData("some payment id");
        //verify mApi.get is called
    }


    @Test
    @JSpec(desc = "should loadCheckoutData call Bus.post with succesful result")
    public void testLoadCheckoutData2() {
        // mock mApi to call callback's onSuccess when its get method is called
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                NetworkCallback networkCallback = (NetworkCallback) invocation.getArguments()[2];
                networkCallback.onSuccess("success");
                return "Sucess";
            }
        }).when(paymentApi).get(eq("some url"), any(HashMap.class), any(NetworkCallback.class));

        model.loadCheckoutData("some payment id");

        //verify mBus.post is called with expected arguments
    }



    @Test
    @JSpec(desc = "should loadCheckoutData call Bus.post with failure result")
    public void testLoadCheckoutData3() {
        // mock mApi to call callback's onFailure when its get method is called
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                NetworkCallback networkCallback = (NetworkCallback) invocation.getArguments()[2];
                networkCallback.onFailure(500, "Server error");
                return "Server error";
            }
        }).when(paymentApi).get(eq("some url"), any(HashMap.class), any(NetworkCallback.class));

        model.loadCheckoutData("some payment id");

        //verify mBus.post is called with expected arguments
    }
}