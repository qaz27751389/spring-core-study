package cn.huzd.springframework.beans.factory.strategy;

import cn.hutool.core.bean.BeanException;
import cn.huzd.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor cotr, Object[] args) throws BeanException {
        Class clazz=beanDefinition.getClass();
        try{
            if(null!=cotr){
                return clazz.getDeclaredConstructor(cotr.getParameterTypes()).newInstance();
            }else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeanException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
