/**
 * projectName: dubbo-parent
 * fileName: HelloServiceImpl.java
 * packageName: com.sikiapp.service.impl
 * date: 2020-02-20 下午8:03
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.dubbo.service.impl;

import com.sikiapp.dubbo.service.HelloService;

/**
 * @className: HelloServiceImpl
 * @packageName: com.sikiapp.service.impl
 * @description:
 * @author: Robert
 * @data: 2020-02-20 下午8:03
 * @version: V1.0
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        System.out.println("Hello world");
        return "sayed ...";
    }
}