package love.wangqi.http.support;

import java.lang.reflect.Method;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-14 15:00
 */
public interface HttpHandler {
    String handle(Method method);
}
