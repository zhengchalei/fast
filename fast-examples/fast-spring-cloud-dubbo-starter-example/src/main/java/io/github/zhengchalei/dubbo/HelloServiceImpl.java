package io.github.zhengchalei.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:stone981023@gmail.com">zhengchalei</a>
 **/
@Service
@DubboService(version = "1.0.0")
public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String name) {
        return name;
    }
}
