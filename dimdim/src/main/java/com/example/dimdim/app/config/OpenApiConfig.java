package com.example.dimdim.app.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI dimdimOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("DimDim API")
                    .description("API de Transações - Checkpoint Docker Compose")
                    .version("1.0.0"))
            .externalDocs(new ExternalDocumentation()
                    .description("Swagger UI")
                    .url("/swagger-ui.html"));
    }
}
