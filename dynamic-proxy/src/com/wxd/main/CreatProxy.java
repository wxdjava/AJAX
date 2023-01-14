package com.wxd.main;

import com.wxd.handler.Broker;
import com.wxd.service.UsbSell;
import com.wxd.serviceImp.Target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author wangxuedeng
 * @date 2023/1/14 - 12:42
 */
public class CreatProxy {
    public static void main(String[] args) {
        UsbSell taobao = new Target();
        InvocationHandler handler = new Broker(taobao);

        Object obj = Proxy.newProxyInstance(taobao.getClass().getClassLoader(), taobao.getClass().getInterfaces(), handler);
        UsbSell proxy = (UsbSell) obj;
        float price = proxy.price(1);
        System.out.println("调用动态代理！！ usb的价格为：" + price);
    }
}
