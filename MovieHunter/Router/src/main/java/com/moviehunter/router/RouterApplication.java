package com.moviehunter.router;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class RouterApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(RouterApplication.class, args);
    }
}
