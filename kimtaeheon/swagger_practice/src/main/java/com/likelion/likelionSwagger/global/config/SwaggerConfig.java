package com.likelion.likelionSwagger.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI SwaggerConfig(){

        Info info = new Info()
                .title("Swagger Test App")
                .description("description : 스프링 스웨거 설명을 위한 앱 입니다.")
                .version("7.7");

        Components components = new Components()
                .addSecuritySchemes("Authorization",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"));

        return new OpenAPI()
                .info(info)
                .components(components)
                .addSecurityItem(
                        new SecurityRequirement().addList("Authorization"));
    }
}
