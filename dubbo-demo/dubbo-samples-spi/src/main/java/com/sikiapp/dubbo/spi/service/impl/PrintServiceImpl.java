/**
 * projectName: dubbo-parent
 * fileName: PrintServiceImpl.java
 * packageName: com.sikiapp.dubbo.spi.service.impl
 * date: 2020-02-03 下午6:57
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.dubbo.spi.service.impl;

import com.sikiapp.dubbo.spi.service.PrintService;

/**
 * @className: PrintServiceImpl
 * @packageName: com.sikiapp.dubbo.spi.service.impl
 * @description:
 * @author: Robert
 * @data: 2020-02-03 下午6:57
 * @version: V1.0
 **/
public class PrintServiceImpl implements PrintService {

    @Override
    public void print() {
        System.out.println("default print service...");
    }
}