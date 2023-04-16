package cn.huzd.springframework.beans.factory.config;


/**
 * 注册单例bean
 */
public interface SingletonBeanRegistry {

    /**
     * 返回给定名称下注册的（原始）单例对象
     * @param beanName 要寻找的bean的名称
     * @return 返回注册的单例对象
     */
    Object getSingleton(String beanName);

    /**
     * 注册单例对象
     * @param beanName Bean对象名称
     * @param singletonObject  Bean对象
     */
    void registerSingleton(String beanName,Object singletonObject);
}
