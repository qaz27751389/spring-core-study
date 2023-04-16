package cn.huzd.springframework.beans.factory.strategy;


import cn.hutool.core.bean.BeanException;
import cn.huzd.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * bean实例化策略接口
 */
public interface InstantiationStrategy {
    /**
     *
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     * @throws BeanException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,Object[] args)throws BeanException;



}
