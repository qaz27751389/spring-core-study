package cn.huzd.springframework.beans.factory.registry;

/**
 * 单例bean注册接口
 */
public interface SingletonBeanRegistry {
    /**
     * 返回在给定名称下注册的（原始）单例对象
     * @param beanName 要查找的bean的名称
     * @return 返回注册的单例对象
     */
    Object getSingleton(String beanName);

    void registerSingleton(String beanName,Object singletonObject);
}
