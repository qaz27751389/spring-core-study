package cn.huzd.springframework.beans.factory.supprot;

import cn.hutool.core.bean.BeanException;
import cn.hutool.core.bean.BeanUtil;
import cn.huzd.springframework.beans.factory.component.PropertyValue;
import cn.huzd.springframework.beans.factory.component.ProperyValues;
import cn.huzd.springframework.beans.factory.config.BeanDefinition;
import cn.huzd.springframework.beans.factory.config.BeanReference;
import cn.huzd.springframework.beans.factory.strategy.CglibSubclassingInstantiationStrategy;
import cn.huzd.springframework.beans.factory.strategy.InstantiationStrategy;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy=new CglibSubclassingInstantiationStrategy();


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean=null;
        try{
            bean=createBeanInstance(beanDefinition,beanName,args);
            //填充属性
            applyPropertyValues(beanName,bean,beanDefinition);
        }catch (Exception e){

        }
        return null;
    }

    private void applyPropertyValues(String beanName,Object bean,BeanDefinition beanDefinition){
        try{
            ProperyValues properyValues=beanDefinition.getProperyValues();
            for (PropertyValue propertyValue:properyValues.getPropertyValues()) {
                String name=propertyValue.getName();
                Object value=propertyValue.getValue();
                if(value instanceof BeanReference){
                    BeanReference  beanReference= (BeanReference) value;
                    value=getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean,name,value);
            }

            }catch (Exception e){
            throw new BeanException("Error setting property values:" + beanName);
        }
        }

        protected  Object createBeanInstance(BeanDefinition beanDefinition,String beanName,Object[] args){
            Constructor constructorToUse=null;
            Class<?> beanClass=beanDefinition.getBeanClass();
            Constructor<?>[] declaredConstructors=beanClass.getDeclaredConstructors();
            for (Constructor ctor: declaredConstructors) {
                if(null!=args&&ctor.getParameterTypes().length==args.length){
                    constructorToUse=ctor;
                    break;
                }
            }
            return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
        }


        public InstantiationStrategy getInstantiationStrategy(){
        return instantiationStrategy;
        }



}
