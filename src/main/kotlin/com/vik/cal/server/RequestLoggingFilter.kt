package com.vik.cal.server

import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

@Component
class RequestLoggingFilter : WebFilter {
    private val logger = KotlinLogging.logger {}

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        logger.info("Incoming request: ${exchange.request.method} ${exchange.request.uri} with query params: ${exchange.request.queryParams}")
        return chain.filter(exchange)
    }
}