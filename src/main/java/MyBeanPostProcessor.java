import edu.ceis.ssiserviceceis.SpringBeanLifeCycleDemo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: Edson A. Terceros T.
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SpringBeanLifeCycleDemo) {
            ((SpringBeanLifeCycleDemo) bean).beforeInit();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SpringBeanLifeCycleDemo) {
            ((SpringBeanLifeCycleDemo) bean).afterInit();
        }
        return bean;
    }
}
