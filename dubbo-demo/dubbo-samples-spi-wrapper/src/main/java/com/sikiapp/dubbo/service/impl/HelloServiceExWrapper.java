/**
 * projectName: dubbo-parent
 * fileName: HelloServiceWrapper.java
 * packageName: com.sikiapp.service.impl
 * date: 2020-02-20 下午8:05
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.dubbo.service.impl;

import com.sikiapp.dubbo.service.HelloService;

/**
 * @className: HelloServiceWrapper
 * @packageName: com.sikiapp.service.impl
 * @description:
 * @author: Robert
 * @data: 2020-02-20 下午8:05
 * @version: V1.0
 **/
public class HelloServiceExWrapper implements HelloService {

    private final HelloService helloService;

    public HelloServiceExWrapper(HelloService helloService) {
        if (helloService == null) {
            throw new IllegalArgumentException("helloService == null");
        }
        this.helloService = helloService;
    }

    @Override
    public String sayHello() {
        System.out.println("enter2....");
        String s = helloService.sayHello();
        System.out.println("exit2....");
        return s;
    }
}