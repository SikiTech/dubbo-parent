/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.common.extension.factory;

import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.ExtensionFactory;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * AdaptiveExtensionFactory
 * 因为有 @Adaptive，将作为ExtensionFactory默认实现类
 */
@Adaptive
public class AdaptiveExtensionFactory implements ExtensionFactory {

    /**
     *  用来缓存所有的工厂实现，包括SpiExtensionFactory 和 SpringExtensionFactory
     *  由于构造初始化时使用了 TreeSet，会按照自然排序 SpiExtensionFactory >> SpringExtensionFactory
     */
    private final List<ExtensionFactory> factories;

    public AdaptiveExtensionFactory() {
        // ExtensionFactory也是通过SPI实现的，因此这里可以获取所有的工厂拓展点加载器
        ExtensionLoader<ExtensionFactory> loader = ExtensionLoader.getExtensionLoader(ExtensionFactory.class);
        List<ExtensionFactory> list = new ArrayList<ExtensionFactory>();
        // getSupportedExtensions内部使用了TreeSet，会按照自然排序spi->spring
        for (String name : loader.getSupportedExtensions()) {
            list.add(loader.getExtension(name));
        }
        factories = Collections.unmodifiableList(list);
    }

    /**
     * 获得拓展对象
     * @param type object type. 拓展接口
     * @param name object name. 拓展名
     * @param <T>
     * @return
     */
    @Override
    public <T> T getExtension(Class<T> type, String name) {
        // 遍历工厂数组，直到获得到ExtensionFactory 类型的拓展对象
        for (ExtensionFactory factory : factories) {
            // 在spi护或者spring中任一个找到都行
            T extension = factory.getExtension(type, name);
            if (extension != null) {
                return extension;
            }
        }
        return null;
    }

}
