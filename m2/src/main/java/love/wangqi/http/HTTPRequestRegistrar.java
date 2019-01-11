package love.wangqi.http;

import love.wangqi.annotation.HTTPRequest;
import love.wangqi.annotation.HTTPUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-11 14:31
 */
public class HTTPRequestRegistrar implements ImportBeanDefinitionRegistrar,
        ResourceLoaderAware, BeanClassLoaderAware, EnvironmentAware, BeanFactoryAware {

    private ClassLoader classLoader;
    private ResourceLoader resourceLoader;
    private Environment environment;
    private BeanFactory beanFactory;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        registerHttpRequest(beanDefinitionRegistry);
    }

    private void registerHttpRequest(BeanDefinitionRegistry beanDefinitionRegistry) {
        ClassPathScanningCandidateComponentProvider classScanner = getClassScanner();
        classScanner.setResourceLoader(this.resourceLoader);

        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(HTTPUtil.class);
        classScanner.addIncludeFilter(annotationTypeFilter);

        String basePackage = "love.wangqi";
        Set<BeanDefinition> beanDefinitionSet = classScanner.findCandidateComponents(basePackage);
        for (BeanDefinition beanDefinition : beanDefinitionSet) {
            if (beanDefinition instanceof AnnotatedBeanDefinition) {
                registerBeans((AnnotatedBeanDefinition)beanDefinition);
            }
        }
    }

    private void registerBeans(AnnotatedBeanDefinition annotatedBeanDefinition) {
        String className = annotatedBeanDefinition.getBeanClassName();
        ((DefaultListableBeanFactory)this.beanFactory).registerSingleton(className, createProxy(annotatedBeanDefinition));
    }

    private ClassPathScanningCandidateComponentProvider getClassScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, this.environment) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                if (beanDefinition.getMetadata().isInterface()) {
                    try {
                        Class<?> target = ClassUtils.forName(
                                beanDefinition.getMetadata().getClassName(),
                                classLoader);
                        return !target.isAnnotation();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return false;
            }
        };
    }

    private Object createProxy(AnnotatedBeanDefinition annotatedBeanDefinition) {
        try {
            AnnotationMetadata annotationMetadata = annotatedBeanDefinition.getMetadata();
            Class<?> target = Class.forName(annotationMetadata.getClassName());
            InvocationHandler invocationHandler = createInvocationHandler();
            Object proxy = Proxy.newProxyInstance(HTTPRequest.class.getClassLoader(), new Class[] {target}, invocationHandler);
            return proxy;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private InvocationHandler createInvocationHandler() {
        return new InvocationHandler() {
            private DemoHttpHandler demoHttpHandler = new DemoHttpHandler();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return demoHttpHandler.handle(method);
            }
        };
    }


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


}
