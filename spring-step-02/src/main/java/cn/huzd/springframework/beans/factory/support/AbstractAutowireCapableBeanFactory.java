package cn.huzd.springframework.beans.factory.support;

import cn.huzd.springframework.beans.factory.BeansException;
import cn.huzd.springframework.beans.factory.config.BeanDefinition;


/**
 * 实现默认bean创建的抽象bean工厂超类
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean=null;
        try{
            bean=beanDefinition.getBeanClass().newInstance();
        }catch (InstantiationException | IllegalAccessException e){
            throw new BeansException("Instantiation of bean failed",e);
        }
        registerSingleton(beanName,bean);
        return null;
    }
}
