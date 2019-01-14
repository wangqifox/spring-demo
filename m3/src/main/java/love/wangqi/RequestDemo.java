package love.wangqi;

import love.wangqi.http.annotation.HttpRequest;
import love.wangqi.http.annotation.HttpUtil;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-14 15:08
 */
@HttpUtil(url = "http://127.0.0.1")
public interface RequestDemo {
    @HttpRequest(path = "/index")
    String test1();

    @HttpRequest(path = "/post", method = "POST")
    String test2();
}
