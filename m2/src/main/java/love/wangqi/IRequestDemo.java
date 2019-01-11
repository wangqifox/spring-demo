package love.wangqi;

import love.wangqi.annotation.HTTPMethod;
import love.wangqi.annotation.HTTPRequest;
import love.wangqi.annotation.HTTPUtil;
import love.wangqi.http.HttpResult;
import org.springframework.stereotype.Component;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-11 14:24
 */
@Component
@HTTPUtil
public interface IRequestDemo {
    @HTTPRequest(url = "http://abc.com")
    HttpResult<String> test1();

    @HTTPRequest(url = "http://test2.com", httpMethod = HTTPMethod.POST)
    HttpResult<String> test2();
}
