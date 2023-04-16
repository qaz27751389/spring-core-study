package cn.huzd.springframework.beans.factory.support;

import cn.huzd.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactrory implements BeanDefinitionRegistry{

    private Map<String,BeanDefinition> beanDefinitionMap=new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition=beanDefinitionMap.get(beanName);
        if(beanDefinition==null){
           //抛异常　
        }
        return beanDefinition ;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);

    }
}
