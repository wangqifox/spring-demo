package love.wangqi;

import org.springframework.stereotype.Component;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-02-18 16:25
 */
@Component
public class Hello {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
