package com.RPS_Assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket getDocumention(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.RPS_Assignment.controller"))
                .paths(regex("/rps.*"))
                .build().apiInfo(apiInfo());


    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("RPS-GAME API")
                .description("API documentation for RPS-GAME")
                .version("1.0.0")
                .build();
    }
}
