package com.chriszou.auttutorial.test.junitrule;

import com.chriszou.auttutorial.junitrule.ContextHolder;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.robolectric.RuntimeEnvironment;

/**
 * Created by xiaochuang on 7/9/16.
 */
public class ContextRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        ContextHolder.set(RuntimeEnvironment.application);
        return base;
    }
}
