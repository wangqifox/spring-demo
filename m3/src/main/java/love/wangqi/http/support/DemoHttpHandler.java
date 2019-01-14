package love.wangqi.http.support;

import love.wangqi.http.annotation.HttpRequest;

import java.lang.reflect.Method;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-14 15:00
 */
public class DemoHttpHandler implements HttpHandler {
    String url;

    public DemoHttpHandler(String url) {
        this.url = url;
    }

    @Override
    public String handle(Method method) {
        HttpRequest httpRequest = method.getAnnotation(HttpRequest.class);
        String path = httpRequest.path();
        String httpMethod = httpRequest.method();

        return httpMethod + " " + url + path;
    }
}
