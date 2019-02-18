package love.wangqi;

import org.springframework.context.ApplicationEvent;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-02-18 16:54
 */
public class EventDemo extends ApplicationEvent {
    private String message;


    public EventDemo(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
