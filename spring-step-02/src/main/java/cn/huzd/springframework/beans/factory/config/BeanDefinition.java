package cn.huzd.springframework.beans.factory.config;


/**
 * 定义bean的实例信息
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass){
        this.beanClass=beanClass;
    }

    public Class getBeanClass(){
        return beanClass;
    }

    public void setBeanClass(Class beanClass){
        this.beanClass=beanClass;
    }

}
