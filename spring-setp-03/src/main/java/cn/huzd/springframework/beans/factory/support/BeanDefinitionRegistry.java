package cn.huzd.springframework.beans.factory.support;

import cn.huzd.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {


    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
