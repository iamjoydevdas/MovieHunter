package com.moviehunter.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class UserManagement 
{
    public static void main( String[] args )
    {
        SpringApplication.run(UserManagement.class, args);
    }
}
