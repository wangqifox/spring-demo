package love.wangqi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-02-18 16:23
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        EventDemoPublish eventDemoPublish = annotationConfigApplicationContext.getBean(EventDemoPublish.class);
        eventDemoPublish.publish("hello");
    }
}
