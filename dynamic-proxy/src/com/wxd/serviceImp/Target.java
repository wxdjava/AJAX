package com.wxd.serviceImp;

import com.wxd.service.UsbSell;

/**
 * @author wangxuedeng
 * @date 2023/1/14 - 12:31
 */
public class Target implements UsbSell {
    @Override
    public float price(int count) {
        return 85.0f;
    }
}
