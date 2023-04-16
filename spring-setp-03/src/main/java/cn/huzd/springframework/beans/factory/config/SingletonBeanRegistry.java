package cn.huzd.springframework.beans.factory.config;

/**
 * 单例bean注册接口
 */
public interface SingletonBeanRegistry {
    /**
     * 返回给定名称下注册的 单例对象
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);


    void registerSingleton(String beanName,Object singletonObject);
}
