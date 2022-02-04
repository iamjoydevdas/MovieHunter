package com.moviehunter.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@EnableEurekaClient
@SpringBootApplication(scanBasePackages="com.moviehunter")
public class MovieManagementApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(MovieManagementApplication.class, args);
    }
}
