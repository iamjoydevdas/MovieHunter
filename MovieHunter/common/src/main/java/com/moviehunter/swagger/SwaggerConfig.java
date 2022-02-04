package com.moviehunter.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)  
				.groupName("Movie Hunter")
				.apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.moviehunter"))
                .apis(RequestHandlerSelectors.withClassAnnotation(ApiOperation.class))
			//	.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))              
				.paths(PathSelectors.any())                          
				.build();                                           
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //Page title
                .title("Spring Boot Swagger2 structure RESTful API")
                //Clause address
                .description("*** Web Service Api Document")
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                //describe
                .build();
    }
}
