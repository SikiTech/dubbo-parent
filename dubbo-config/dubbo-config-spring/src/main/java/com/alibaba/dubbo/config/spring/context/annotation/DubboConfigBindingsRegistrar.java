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
package com.alibaba.dubbo.config.spring.context.annotation;

import com.alibaba.dubbo.config.AbstractConfig;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;

/**
 * {@link AbstractConfig Dubbo Config} binding Bean registrar for {@link EnableDubboConfigBindings}
 *
 * @see EnableDubboConfigBindings
 * @see DubboConfigBindingRegistrar
 * @since 2.5.8
 */
public class DubboConfigBindingsRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private ConfigurableEnvironment environment;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // <1.1> 获得 @EnableDubboConfigBindings 注解
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(
                importingClassMetadata.getAnnotationAttributes(EnableDubboConfigBindings.class.getName()));

        // <1.2> 获得内部的 @EnableDubboConfigBinding 注解的数组
        AnnotationAttributes[] annotationAttributes = attributes.getAnnotationArray("value");

        // <2> 创建 DubboConfigBindingRegistrar 对象，并设置 environment 属性
        DubboConfigBindingRegistrar registrar = new DubboConfigBindingRegistrar();
        registrar.setEnvironment(environment);

        // <3> 遍历 annotationAttributes 数组，使用 registrar 进行逐个 @EnableDubboConfigBinding 注解的注册对应的 Bean
        for (AnnotationAttributes element : annotationAttributes) {
            // 将每个EnnableDubboConfigBinding注解包含的Bean注册到Spring容器
            registrar.registerBeanDefinitions(element, registry);
        }
    }

    @Override
    public void setEnvironment(Environment environment) {

        Assert.isInstanceOf(ConfigurableEnvironment.class, environment);

        this.environment = (ConfigurableEnvironment) environment;

    }

}
