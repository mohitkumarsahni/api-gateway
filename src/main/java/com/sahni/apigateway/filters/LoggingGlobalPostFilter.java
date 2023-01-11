package com.sahni.apigateway.filters;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class LoggingGlobalPostFilter {

    final Logger logger = (Logger) LoggerFactory.getLogger(LoggingGlobalPostFilter.class);

    @Bean
    public GlobalFilter postGlobalFilter() {
        return (exchange, chain) -> {
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        logger.info("Outgoing Response...");
                        logger.info("Request ID: {}", exchange.getRequest().getId());
                        logger.info("Status Code: {}", exchange.getResponse().getStatusCode());
                    }));
        };
    }
}
