package cn.huzd.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import cn.huzd.springframework.beans.factory.config.BeanDefinition;
import cn.huzd.springframework.beans.factory.strategy.CglibSubclassingInstantiationStrategy;
import cn.huzd.springframework.beans.factory.strategy.InstantiationStrategy;

import java.lang.reflect.Constructor;

/**
 * 实现默认bean创建的抽象工厂超类(充当策略模式中的上下文类）
 */
public abstract class AbstractAutowireCapableBeanFactrory extends AbstractBeanFactory {

    private InstantiationStrategy  instantiationStrategy=new CglibSubclassingInstantiationStrategy();


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException {
       Object bean=null;
       try{
           bean=createBeanInstance(beanDefinition,beanName,args);

       }catch (Exception e){

       }
       registerSingleton(beanName,bean);

        return null;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition,String beanName,Object[] args){
        Constructor constructor=null;
        Class<?> beanClass=beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors=beanClass.getDeclaredConstructors();
        for (Constructor ctor:declaredConstructors){
            if(null!= args&& ctor.getParameterTypes().length== args.length){
                constructor=ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructor,args);
    }

    public InstantiationStrategy getInstantiationStrategy(){
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy){
        this.instantiationStrategy=instantiationStrategy;
    }


}
