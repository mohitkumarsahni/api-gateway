package com.sahni.apigateway.filters;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingGlobalPreFilter implements GlobalFilter {

    final Logger logger = (Logger) LoggerFactory.getLogger(LoggingGlobalPreFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Incoming request...");
        logger.info("Request ID: {}", exchange.getRequest().getId());
        logger.info("Request URI: {}", exchange.getRequest().getURI());
        logger.info("Request params: {}", exchange.getRequest().getQueryParams());
        logger.info("Request path: {}", exchange.getRequest().getPath());
        return chain.filter(exchange);
    }
}
