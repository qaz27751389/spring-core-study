package cn.huzd.springframework.beans.factory.config;


import cn.huzd.springframework.beans.factory.component.PropertyValue;
import cn.huzd.springframework.beans.factory.component.ProperyValues;
import lombok.Data;

/**
 * 定义bean的实例信息
 */
@Data
public class BeanDefinition {

    private Class beanClass;

    private ProperyValues properyValues;

    public BeanDefinition(Class beanClass){
        this.beanClass=beanClass;
        this.properyValues=new ProperyValues();
    }
    public BeanDefinition(Class beanClass, ProperyValues propertyValues){
        this.beanClass=beanClass;
        this.properyValues=propertyValues!=null?propertyValues:new ProperyValues();
    }




}
