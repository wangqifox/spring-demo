package love.wangqi.http;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-11 14:35
 */
public class StringHttpResult implements HttpResult<String> {
    private String result;
    private int status;

    public StringHttpResult(String result, int status) {
        this.result = result;
        this.status = status;
    }

    @Override
    public String getResponse() {
        return this.result;
    }

    @Override
    public int getStatus() {
        return this.status;
    }
}
