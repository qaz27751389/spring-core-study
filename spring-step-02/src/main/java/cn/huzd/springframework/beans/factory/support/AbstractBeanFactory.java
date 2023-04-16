package cn.huzd.springframework.beans.factory.support;

import cn.huzd.springframework.beans.factory.BeanFactory;
import cn.huzd.springframework.beans.factory.BeansException;
import cn.huzd.springframework.beans.factory.config.BeanDefinition;

import javax.swing.plaf.basic.BasicTabbedPaneUI;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory{

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean= getSingleton(name);
        if(bean !=null){
            return bean;
        }
        BeanDefinition beanDefinition=getBeanDefinition(name);
        return createBean(name,beanDefinition);
    }


    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition);
}
