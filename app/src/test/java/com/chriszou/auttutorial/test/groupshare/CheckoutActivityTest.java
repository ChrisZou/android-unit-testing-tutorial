package com.chriszou.auttutorial.test.groupshare;

import com.chriszou.auttutorial.BuildConfig;
import com.chriszou.auttutorial.groupshare.CheckoutActivity;
import com.chriszou.auttutorial.groupshare.DataLoadedEvent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by xiaochuang on 4/25/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CheckoutActivityTest {

    private CheckoutActivity mActivity;

    @Before
    public void setup() {
        mActivity = Robolectric.setupActivity(CheckoutActivity.class);
    }

    @Test
    @JSpec(desc = "should call CheckoutModel.loadCheckoutData when activity starts")
    public void testActivityStarts() {
        //Verify that mCheckoutData's loadCheckoutData method is called
    }

    @Test
    public void testOnDataLoadedEvent_success() throws Exception {
        DataLoadedEvent event = new DataLoadedEvent(new Object());
        mActivity.onDataLoadedEvent(event);

        //Verify view updated correctly
    }

    @Test
    public void testOnDataLoadedEvent_failure() throws Exception {
        DataLoadedEvent event = new DataLoadedEvent(500, "Server error");
        mActivity.onDataLoadedEvent(event);

        //Verify error message shown
    }
}