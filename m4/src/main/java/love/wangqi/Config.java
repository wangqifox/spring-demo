package love.wangqi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-02-18 16:22
 */
@Configuration
@ComponentScan("love.wangqi")
@EnableAsync
public class Config {
    @Bean
    public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

//    @Bean
//    public SimpleApplicationEventMulticaster applicationEventMulticaster() {
//        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
//        simpleApplicationEventMulticaster.setTaskExecutor(simpleAsyncTaskExecutor());
//        return simpleApplicationEventMulticaster;
//    }
}
