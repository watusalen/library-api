package com.matusalenalves.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

/**
 * Configura os valores padrão de paginação usados em toda listagem da API
 * (RNF12): tamanho de página padrão de 20 itens, com máximo de 100 — acima
 * desse limite, a requisição é truncada para 100, não rejeitada.
 */
@Configuration
public class PaginationConfig {

    private static final int DEFAULT_PAGE_SIZE = 20;
    private static final int MAX_PAGE_SIZE = 100;

    @Bean
    public PageableHandlerMethodArgumentResolverCustomizer pageableCustomizer() {
        return resolver -> {
            resolver.setFallbackPageable(org.springframework.data.domain.PageRequest.of(0, DEFAULT_PAGE_SIZE));
            resolver.setMaxPageSize(MAX_PAGE_SIZE);
        };
    }
}