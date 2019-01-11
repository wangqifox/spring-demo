package love.wangqi.http;

import love.wangqi.annotation.HTTPRequest;

import java.lang.reflect.Method;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-11 14:37
 */
public class DemoHttpHandler implements HTTPHandler {

    @Override
    public HttpResult<?> handle(Method method) {
        HTTPRequest request = method.getAnnotation(HTTPRequest.class);
        String url = request.url();
        String methodName = request.httpMethod().name();
        String str = String.format("http request: url=%s and method=%s", url, methodName);
        return new StringHttpResult(str, 200);
    }
}
