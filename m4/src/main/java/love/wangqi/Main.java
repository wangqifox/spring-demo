package love.wangqi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-02-18 16:23
 */
public class Main {
    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        EventDemoPublish eventDemoPublish = annotationConfigApplicationContext.getBean(EventDemoPublish.class);
        logger.info("=== start ===");
        eventDemoPublish.publish("hello");
        logger.info("=== end ===");
    }
}
