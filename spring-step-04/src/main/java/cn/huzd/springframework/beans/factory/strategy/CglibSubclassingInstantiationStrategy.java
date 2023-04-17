package cn.huzd.springframework.beans.factory.strategy;

import cn.hutool.core.bean.BeanException;
import cn.huzd.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

public class CglibSubclassingInstantiationStrategy  implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor cotr, Object[] args) throws BeanException {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(beanDefinition.getClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null==cotr){
            return enhancer.create();
        }

        return enhancer.create(cotr.getParameterTypes(),args);
    }
}
