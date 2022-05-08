package io.github.zhengchalei.fast.web.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 配置属性
 *
 * @author zhengchalei
 * @since 1.0.0
 */
@EnableConfigurationProperties
@Configuration
@ConfigurationProperties("swagger")
public class SwaggerConfigurationProperties {
}
