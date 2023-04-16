import bean.UserService;
import cn.huzd.springframework.beans.factory.config.BeanDefinition;
import cn.huzd.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test_BeanFactory(){
        //1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();

        //2.注册bean
        BeanDefinition beanDefinition=new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //3.获取bean
        UserService userService=(UserService) beanFactory.getBean("userService","ABC");
        userService.queryUserInfo();
    }

}
