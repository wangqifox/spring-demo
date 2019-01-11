package love.wangqi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-11 14:31
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HTTPRequest {
    HTTPMethod httpMethod() default HTTPMethod.GET;
    String url();
}
