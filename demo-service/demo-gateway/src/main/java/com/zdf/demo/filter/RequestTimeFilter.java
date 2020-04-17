package com.zdf.demo.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class RequestTimeFilter implements GatewayFilter, Ordered {

	private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";

	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		exchange.getAttributes().put(REQUEST_TIME_BEGIN,System.currentTimeMillis());
		return chain.filter(exchange).then(
				
				);
	}

	public int getOrder() {
		return 0;
	}

}
