package br.com.compassuol.pb.challenge.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig{

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("auth", r -> r
                        .path("/oauth/token")
                        .uri("http://localhost:8082/"))
                .route("register", r -> r
                        .path("/register")
                        .uri("http://localhost:8082/"))
                .route("products", r -> r
                        .path("/products")
                        .uri("http://localhost:8081/"))
                .route("users", r -> r
                        .path("/users")
                        .uri("http://localhost:8081/"))
                .route("category", r -> r
                        .path("/category")
                        .uri("http://localhost:8081/"))
                .build();
    }
}
