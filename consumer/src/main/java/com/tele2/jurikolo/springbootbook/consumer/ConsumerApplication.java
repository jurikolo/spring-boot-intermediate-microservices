package com.tele2.jurikolo.springbootbook.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tele2.jurikolo.springbootbook.commons.CommentstoreObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableRetry
public class ConsumerApplication {

    @Bean
    @Primary
    ObjectMapper objectMapper() {
        return new CommentstoreObjectMapper();
    }

    @Bean
    RestTemplate restTemplate(
            @Value("${commentstore.auth.user}") String username,
            @Value("${commentstore.auth.password}") String password,
            RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.getInterceptors().add(0, new BasicAuthorizationInterceptor(username, password));
        return restTemplate;
    }

    @Bean
    CommentService commentService() {
        return new CommentService();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}