package com.sikiapp.dubbo.spi.service;

import com.alibaba.dubbo.common.extension.SPI;

@SPI("impl")
public interface PrintService {

    void print();
}
