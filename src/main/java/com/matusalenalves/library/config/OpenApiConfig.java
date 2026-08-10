package com.matusalenalves.library.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Documentação interativa da API via Swagger/OpenAPI (RF27, RNF13),
 * disponível em {@code /swagger-ui.html} e {@code /v3/api-docs}, ambos
 * liberados para acesso público em {@code SecurityConfig}.
 * <p>
 * Declara o esquema de autenticação Bearer/JWT (RNF04) para que o Swagger UI
 * ofereça o botão "Authorize", permitindo testar os endpoints protegidos
 * diretamente pela documentação.
 */
@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME_NAME = "bearerAuth";

    @Bean
    public OpenAPI libraryOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Library API")
                        .description("API REST para gerenciamento de biblioteca, com autenticação JWT e controle de acesso por perfil.")
                        .version("v1"))
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME, new SecurityScheme()
                                .name(SECURITY_SCHEME_NAME)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}