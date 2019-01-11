package love.wangqi;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-11 11:27
 */
@Component
public class PersonBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;

        BeanDefinitionBuilder personManagerBeanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(PersonManager.class);
        BeanDefinition personManagerBeanDefinition = personManagerBeanDefinitionBuilder.getRawBeanDefinition();
        defaultListableBeanFactory.registerBeanDefinition("personManager", personManagerBeanDefinition);


        BeanDefinitionBuilder personDaoBeanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(PersonDao.class);
        BeanDefinition personDaoBeanDefinition = personDaoBeanDefinitionBuilder.getRawBeanDefinition();
        defaultListableBeanFactory.registerBeanDefinition("personDao", personDaoBeanDefinition);
    }
}
