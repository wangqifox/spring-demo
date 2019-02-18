package love.wangqi;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-02-18 16:58
 */
@Component
public class EventDemoListener implements ApplicationListener<EventDemo> {
    @Override
    public void onApplicationEvent(EventDemo event) {
        System.out.println("receiver " + event.getMessage());
    }
}
