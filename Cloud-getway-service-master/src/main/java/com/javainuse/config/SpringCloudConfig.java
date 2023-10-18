package com.javainuse.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@CrossOrigin(origins="*")
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/articles/**")
                        .uri("lb://ARTICLE")
                        .id("aa"))
                .route(r -> r.path("/commandes/**")
                        .uri("lb://COMMANDE")
                        .id("bb"))
                .route(r -> r.path("/factures/**")
                        .uri("lb://FACTURE-SERVICE")
                        .id("cc"))
                .route(r -> r.path("/fournisseurs/**")
                        .uri("lb://FOURNISSEUR")
                        .id("dd"))
                .route(r -> r.path("/produits/**")
                        .uri("lb://PRODUIT")
                        .id("ee"))
                .route(r -> r.path("/paniers/**")
                        .uri("lb://SERVICEPANIER")
                        .id("ff"))
                .route(r -> r.path("/users/**")
                        .uri("lb://USERSERVICEMONGO")
                        .id("ff"))            
                .build();
    }
    
}