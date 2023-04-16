import cn.huzd.springframework.beans.factory.UserService;
import cn.huzd.springframework.beans.factory.config.BeanDefinition;
import cn.huzd.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class test01 {

@Test
    public void testBeanFactory(){
        // 1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
        //2.注入bean
        BeanDefinition beanDefinition=new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        //获取bean
        UserService userService=(UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        //第二次获取bean 从缓存中获取
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }
}
