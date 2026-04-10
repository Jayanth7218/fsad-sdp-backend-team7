package com.klef.fsad.springbootbackendproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig 
{
    @Bean
    public OpenAPI customOpenAPI() 
    {
        return new OpenAPI()
                .info(new Info()
                        .title("Student Performance Analytics API")
                        .version("1.0")
                        .description("FSAD SDP Project - Student Performance Analytics and Reporting System"));
    }
}
