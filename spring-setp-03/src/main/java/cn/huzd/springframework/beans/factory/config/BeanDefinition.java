package cn.huzd.springframework.beans.factory.config;

/**
 * 定义bean实例信息
 */
public class BeanDefinition {

    private Class beanClass;
    //构造函数定义封装对象
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
