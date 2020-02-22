package com.sikiapp.dubbo.service;

import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface HelloService {
    String sayHello();
}
