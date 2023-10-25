package com.javainuse;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
@SpringBootApplication
@EnableEurekaClient
@RequiredArgsConstructor
public class APIGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(APIGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("produit/**")
						.uri("http://localhost:8092/"))
				.route(r -> r.path("commandes/**")
						.uri("http://localhost:8083/"))
				.route(r -> r.path("facture/**")
						.uri("http://localhost:8084/"))
				.route(r -> r.path("fournisseurs/**")
						.uri("http://localhost:8099/"))
				.route(r -> r.path("servicePanier/**")
						.uri("http://localhost:8062/"))
				.route(r -> r.path("users/**")
						.uri("http://localhost:5000/"))
				.build();
	}

}
