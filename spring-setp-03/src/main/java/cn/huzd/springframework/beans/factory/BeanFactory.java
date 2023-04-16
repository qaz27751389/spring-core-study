package cn.huzd.springframework.beans.factory;

import cn.hutool.core.bean.BeanException;

/**
 * bean工厂，所实现的接口方法，主要用来返回已经创建成功的Bean的实例对象
 */
public interface BeanFactory {

    /**
     * 返回bean的实例对象（不含构造函数）
     * @param name  要检索的bean的名称
     * @return  实例化的bean对象
     * @throws BeanException  不能获取bean对象，则抛出异常　
     */
    Object getBean(String name) throws BeanException;

    /**
     * 返回含构造函数的bean的实例对象
     * @param name  要检索的bean的名称
     * @param args 构造函数入参
     * @return  实例化的bean对象
     * @throws BeanException  不能获取Bean对象，则抛出异常
     */
    Object getBean(String name,Object...args) throws  BeanException;
}
