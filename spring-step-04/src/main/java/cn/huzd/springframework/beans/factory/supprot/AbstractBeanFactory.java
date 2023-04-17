package cn.huzd.springframework.beans.factory.supprot;

import cn.hutool.core.bean.BeanException;
import cn.huzd.springframework.beans.factory.config.BeanDefinition;
import cn.huzd.springframework.beans.factory.registry.DefaultSingletonBeanRegistry;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeanException{
        return doGetBean(name,null);
    }


    protected <T> T doGetBean(final String name,final Object[] args){
        Object bean= getSingleton(name);
        if(bean!=null){
            return (T) bean ;
        }
        BeanDefinition beanDefinition=getBeanDefinition(name);
        return (T)createBean(name,beanDefinition,args);
    }



    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] args);








}
