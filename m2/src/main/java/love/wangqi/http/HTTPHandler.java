package love.wangqi.http;

import java.lang.reflect.Method;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-11 14:36
 */
public interface HTTPHandler {
    HttpResult<?> handle(Method method);
}
