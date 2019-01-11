package love.wangqi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-11 11:25
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        IRequestDemo iRequestDemo = annotationConfigApplicationContext.getBean(IRequestDemo.class);
        System.out.println(iRequestDemo.test1().getResponse());
        System.out.println(iRequestDemo.test2().getResponse());
    }
}
