package io.github.zhengchalei.nacos.example;


import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FastSpringCloudNacosStarterExample {
    public static void main(String[] args) {
        SpringApplication.run(FastSpringCloudNacosStarterExample.class, args);
    }

    @Bean
    public ApplicationRunner runner(RestTemplate restTemplate) {
        return args -> {
//            String json = restTemplate.getForObject("http://service/test", String.class);
//            System.out.println(json);
        };
    }
}
