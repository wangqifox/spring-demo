package love.wangqi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-14 10:52
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        RequestDemo requestDemo = annotationConfigApplicationContext.getBean(RequestDemo.class);
        System.out.println(requestDemo.test1());
        System.out.println(requestDemo.test2());
    }
}
