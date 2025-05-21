package com.vik.cal.config

import reactor.core.publisher.Hooks
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Configuration

@Configuration
class TracingConfig {
    @PostConstruct
    fun setupHooks() {
        Hooks.enableAutomaticContextPropagation()
    }
}
