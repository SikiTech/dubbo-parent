/**
 * projectName: dubbo-parent
 * fileName: EchoConsumer.java
 * packageName: com.sikiapp.dubbo.echo
 * date: 2020-02-03 下午6:42
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.dubbo.echo;

import com.alibaba.dubbo.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @className: EchoConsumer
 * @packageName: com.sikiapp.dubbo.echo
 * @description:
 * @author: Robert
 * @data: 2020-02-03 下午6:42
 * @version: V1.0
 **/
public class EchoConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/echo-consumer.xml"});
        DemoService echoService = (DemoService)context.getBean("echoService");
        String status = echoService.sayHello("Hello World");
        System.out.println("echo result:" + status);
    }
}