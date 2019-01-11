package love.wangqi.http;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-11 14:34
 */
public interface HttpResult<T> {
    T getResponse();

    int getStatus();
}
