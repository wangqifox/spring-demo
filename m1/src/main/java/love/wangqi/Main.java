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
        PersonManager personManager = annotationConfigApplicationContext.getBean(PersonManager.class);
        System.out.println(personManager.hello());
    }
}
