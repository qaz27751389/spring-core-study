package cn.huzd.springframework.beans.factory.support;

import cn.huzd.springframework.beans.factory.BeansException;
import cn.huzd.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;


/**
 * 默认的工厂实现类
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements  BeanDefinitionRegistry{

    private Map<String,BeanDefinition> beanDefinitionMap=new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition=beanDefinitionMap.get(beanName);
        if(beanDefinition==null) throw new BeansException("No bean named'"+beanName+"'is defined");
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);

    }
}
