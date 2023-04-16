package cn.huzd.springframework.beans.factory.strategy;

import cn.hutool.core.bean.BeanException;
import cn.huzd.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * Jdk实例化策略
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException {
        Class clazz=beanDefinition.getBeanClass();
        try{
            //判断是否有构造函数
            if(null!=ctor){
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.getDeclaredConstructor().newInstance();
            }

        }catch (Exception e){
            throw new BeanException("Failed to instantiate ["+clazz.getName()+"]",e);

        }



    }
}
