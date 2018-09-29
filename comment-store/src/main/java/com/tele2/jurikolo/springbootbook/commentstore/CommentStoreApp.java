package com.tele2.jurikolo.springbootbook.commentstore;

import javax.servlet.Filter;

import com.tele2.jurikolo.springbootbook.logging.RequestContextLoggingFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.tele2.jurikolo.springbootbook.commons.CommentstoreObjectMapper;

/**
 * Application Configuration and Starter for the commentstore
 * @author Jens Boje
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.tele2.jurikolo.springbootbook"})
//@EnableJpaRepositories(basePackages= {"com.tele2.jurikolo.springbootbook"})
@EntityScan(basePackages= {"com.tele2.jurikolo.springbootbook"})
@ImportResource(value={"classpath*:legacy-context.xml"})
public class CommentStoreApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CommentStoreApp.class, args);
    }

    /**
     * Maps the commons logging Filter to all requests; done by spring boot
     * @return
     */
    @Bean
    public Filter initRequestContextLoggingFilter() {
        return new RequestContextLoggingFilter();
    }
    
    @Bean
    @Primary
    public ObjectMapper initObjectMapper() {
        return new CommentstoreObjectMapper();
    }
    
}
