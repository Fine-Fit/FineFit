package com.finefit.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .addServersItem(new Server().url("https://api.finefit.co.kr/").description("운영 환경"))
        .addServersItem(new Server().url("http://localhost:8080/").description("로컬 환경"))
        .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
        .components(new Components()
            .addSecuritySchemes("bearerAuth",
                new SecurityScheme()
                    .name("access")
                    .type(Type.APIKEY)
                    .in(SecurityScheme.In.HEADER)
                    .bearerFormat("JWT")))
        .info(new Info()
            .title("FineFit API")
            .version("API v1.0")
            .description("API documentation"));
  }
}
