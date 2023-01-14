package com.wxd.handler;

import com.wxd.serviceImp.Target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangxuedeng
 * @date 2023/1/14 - 12:34
 */
public class Broker implements InvocationHandler {
    private Object target = null;

    public Broker(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用目标类的方法！！");
        Object res = method.invoke(target, args);
        //功能增强
        float price = (float) ((Float) res + 25.0);

        System.out.println("送五元优惠券！！");
        return price;
    }
}
