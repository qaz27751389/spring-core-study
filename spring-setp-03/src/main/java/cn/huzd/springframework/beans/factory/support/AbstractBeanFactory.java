package cn.huzd.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import cn.huzd.springframework.beans.factory.BeanFactory;
import cn.huzd.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    /**
     * 获取无参bean
     * @param name  要检索的bean的名称
     * @return
     * @throws BeanException
     */
    @Override
    public Object getBean(String name) throws BeanException {
        return null;
    }

    /**
     * 获取有参构造函数bean
     * @param name  要检索的bean的名称
     * @param args 构造函数入参
     * @return
     * @throws BeanException
     */
    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return doGetBean(name,null);
    }

    protected <T> T doGetBean(final String name,final Object[] args){
        Object bean=getSingleton(name);
        if(bean!=null){
            return (T) bean;
        }
        BeanDefinition beanDefinition=getBeanDefinition(name);
        return (T)createBean(name,beanDefinition,args);
    }

    protected abstract  Object createBean(String name, BeanDefinition beanDefinition, Object[] args) ;

    protected abstract  BeanDefinition getBeanDefinition(String name) ;





}
