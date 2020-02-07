/**
 * projectName: dubbo-parent
 * fileName: MyBalance.java
 * packageName: com.sikiapp.dubbo.spi.service.impl
 * date: 2020-02-05 下午5:38
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.dubbo.spi.service.impl;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;

import java.util.List;

/**
 * @className: MyBalance
 * @packageName: com.sikiapp.dubbo.spi.service.impl
 * @description: 负载均衡
 * @author: Robert
 * @data: 2020-02-05 下午5:38
 * @version: V1.0
 **/
public class MyBalance implements LoadBalance {
    @Override
    public <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {
        System.out.println("Select first invoker ...");
        return invokers.get(0);
    }
}