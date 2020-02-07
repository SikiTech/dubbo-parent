/**
 * projectName: dubbo-parent
 * fileName: SpiDemo.java
 * packageName: com.sikiapp.dubbo.spi
 * date: 2020-02-03 下午6:49
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.dubbo.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.sikiapp.dubbo.spi.service.PrintService;

/**
 * @className: SpiDemo
 * @packageName: com.sikiapp.dubbo.spi
 * @description:
 * @author: Robert
 * @data: 2020-02-03 下午6:49
 * @version: V1.0
 **/
public class SpiDemo {

    public static void main(String[] args) {
        PrintService service = ExtensionLoader.getExtensionLoader(PrintService.class)
                .getDefaultExtension();
        service.print();
    }
}