package com.chriszou.auttutorial.test.junitrule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by xiaochuang on 7/9/16.
 */
public class MethodNameExample implements TestRule {
    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                String className = description.getClassName();
                String methodName = description.getMethodName();
                base.evaluate();
                System.out.println("Class name: "+className +", method name: "+methodName);
            }
        };
    }
}
