import bean.UserService;
import cn.huzd.springframework.BeanDefinition;
import cn.huzd.springframework.BeanFactory;

public class ApiTest {

    public void testBeanFactory(){
        // 1.初始化BeanFactory
        BeanFactory beanFactory=new BeanFactory();
        //2.注入bean
        BeanDefinition beanDefinition=new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        //获取bean
        UserService userService=(UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
