package com.kealliang.laboratory.aop;

import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

/**
 * @author lsr
 * @ClassName AopExtendTest
 * @Date 2020-05-21
 * @Vertion 1.0
 */
public class AopExtendTest {

    class SampleBean {
        public String getName() {
            return "Keal Liang";
        }

        public void setName(String name) {
        }

        public int getAge() {
            return 10;
        }
    }

    class SimpleBeforeAdvice implements MethodBeforeAdvice {
        @Override
        public void before(Method method, Object[] args, Object target) throws Throwable {
            System.out.println("Before method: " + method);
        }
    }

    /**
     * 组合切入点测试
     *
     * union 取并集
     * intersection 取交集
     *
     * @author lsr
     * @description composablePointcutTest
     * @Date 2020/5/21
     */
    @Test
    public void composablePointcutTest () {
        // create target
        SampleBean target = new SampleBean();

        ComposablePointcut pc = new ComposablePointcut(ClassFilter.TRUE,
                new GetterMethodMatcher());

        System.out.println("Test 1");
        SampleBean proxy = getProxy(pc, target);
        testInvoke(proxy);

        System.out.println("Test 2");
        pc.union(new SetterMethodMatcher());
        proxy = getProxy(pc, target);
        testInvoke(proxy);

        System.out.println("Test 3");
        pc.intersection(new GetAgeMethodMatcher());
        proxy = getProxy(pc, target);
        testInvoke(proxy);

    }

    private SampleBean getProxy(ComposablePointcut pc, SampleBean target) {
        // create the advisor
        Advisor advisor = new DefaultPointcutAdvisor(pc,
                new SimpleBeforeAdvice());

        // create the proxy
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);

        return (SampleBean) pf.getProxy();
    }

    private static void testInvoke(SampleBean proxy) {
        proxy.getAge();
        proxy.getName();
        proxy.setName("Rob Harrop");
    }

    private static class GetterMethodMatcher extends StaticMethodMatcher {

        public boolean matches(Method method, Class cls) {
            return (method.getName().startsWith("get"));
        }

    }
    private static class SetterMethodMatcher extends StaticMethodMatcher {

        public boolean matches(Method method, Class cls) {
            return (method.getName().startsWith("set"));
        }

    }

    private static class GetAgeMethodMatcher extends StaticMethodMatcher {
        public boolean matches(Method method, Class cls) {
            return "getAge".equals(method.getName());
        }
    }

}
