package cn.huzd.springframework.beans.factory.supprot;


import cn.hutool.core.bean.BeanException;

/**
 * 定义bean工厂接口
 */
public interface BeanFactory {
    /**
     * 返回Bean的实例对象
     * @param name  要检索的bean的名称
     * @return  实例化的Bean对象
     * @throws BeanException 不能获取Bean对象，则抛出异常
     */
    Object getBean(String name) throws BeanException;


    /**
     * 返回构造函数的Bean实例对象
     * @param name 要检索的bean的名称
     * @param args 构造函数入餐
     * @return 实例化的bean对象
     * @throws BeanException  不能获取Bean对象，则抛出异常
     */
    Object getBean(String name,Object...args) throws BeanException;
}
