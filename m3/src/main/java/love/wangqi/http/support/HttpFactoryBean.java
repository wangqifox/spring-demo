package love.wangqi.http.support;

import love.wangqi.http.annotation.HttpRequest;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-14 14:38
 */
public class HttpFactoryBean implements FactoryBean<Object>, InitializingBean {
    private Class<?> type;

    private String url;

    @Override
    public Object getObject() throws Exception {
        if (!this.url.startsWith("http")) {
            this.url = "http://" + this.url;
        }
        return createProxy(this.url);
    }

    private Object createProxy(String url) {
        InvocationHandler invocationHandler = createInvocationHandler(url);
        Object proxy = Proxy.newProxyInstance(HttpRequest.class.getClassLoader(), new Class[] {type}, invocationHandler);
        return proxy;
    }

    private InvocationHandler createInvocationHandler(String url) {
        return new InvocationHandler() {
            private HttpHandler httpHandler = new DemoHttpHandler(url);

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return httpHandler.handle(method);
            }
        };
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
