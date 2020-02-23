/**
 * projectName: dubbo-parent
 * fileName: WrapperDemo.java
 * packageName: com.sikiapp.dubbo
 * date: 2020-02-20 下午8:24
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.sikiapp.dubbo.service.HelloService;

import java.io.IOException;

/**
 * @className: WrapperDemo
 * @packageName: com.sikiapp.dubbo
 * @description:
 * @author: Robert
 * @data: 2020-02-20 下午8:24
 * @version: V1.0
 **/
public class WrapperDemo {

    public static void main(String[] args) throws IOException {
        ExtensionLoader<HelloService> loader = ExtensionLoader.getExtensionLoader(HelloService.class);
        HelloService service = loader.getExtension("default");
        String s = service.sayHello();
        System.out.println(s);

        System.in.read(); // press any key to exit
    }




}