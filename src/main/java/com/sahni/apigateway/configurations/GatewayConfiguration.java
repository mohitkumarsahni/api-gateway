package com.sahni.apigateway.configurations;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/v1/tasks/**")
                        .uri("http://localhost:8081/api/v1/tasks/"))
                .route(r -> r.path("/api/v1/tasklists/**")
                        .uri("http://localhost:8081/api/v1/tasklists/"))
                .build();
    }
}
