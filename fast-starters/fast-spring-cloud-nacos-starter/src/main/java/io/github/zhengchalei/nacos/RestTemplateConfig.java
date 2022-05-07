package io.github.zhengchalei.nacos;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author <a href="mailto:stone981023@gmail.com">zhengchalei</a>
 **/
@Component
@EnableFeignClients
@ConditionalOnMissingBean(RestTemplate.class)
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(List<ClientHttpRequestInterceptor> clientHttpRequestInterceptors) {
        return new RestTemplateBuilder()
                .interceptors(clientHttpRequestInterceptors)
                .build();
    }

}
