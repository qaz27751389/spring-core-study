package cn.huzd.springframework.beans.factory;


/**
 * 定义bean工厂接口
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;
}
