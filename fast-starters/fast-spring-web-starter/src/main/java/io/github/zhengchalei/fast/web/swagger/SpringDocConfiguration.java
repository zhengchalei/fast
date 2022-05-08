package io.github.zhengchalei.fast.web.swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.Data;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * spring文档配置
 *
 * @author zhengchalei
 * @since 1.0.0
 */
@Data
@Configuration
public class SpringDocConfiguration {

    @Value("${spring.application.name ?: 'athena'}")
    private String applicationName;

    /**
     * GroupedOpenApi
     *
     * @return OpenAPI
     */
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group(applicationName)
                .pathsToMatch("/**")
                .build();
    }

    /**
     * 复杂版
     *
     * @return OpenAPI
     */
    @Bean
    public OpenAPI springShopOpenApi() {
        return new OpenAPI()
                .info(new Info().title(applicationName + " API")
                        .description(applicationName + " api")
                        .version("v1.0.0")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://zhengchalei.github.io")
                        )
                )
                .externalDocs(new ExternalDocumentation()
                        .description(applicationName)
                        .url("https://zhengchalei.github.io"));
    }
}
