package love.wangqi.annotation;

import love.wangqi.http.HTTPRequestRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-11 14:29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(HTTPRequestRegistrar.class)
public @interface EnableHttpUtil {
}
