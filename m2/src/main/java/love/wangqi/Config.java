package love.wangqi;

import love.wangqi.annotation.EnableHttpUtil;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-11 11:28
 */
@Configuration
@ComponentScan("love.wangqi")
@EnableHttpUtil
public class Config {
}
