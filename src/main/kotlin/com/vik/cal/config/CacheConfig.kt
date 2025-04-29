package com.vik.cal.config

import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit
import org.springframework.beans.factory.annotation.Value


@Configuration
@EnableCaching
class CacheConfig {

    @Value("\${cache.caffeine.maximum-size}")
    private var maximumSize: Long = 0

    @Value("\${cache.caffeine.expire-after-write}")
    private var expireAfterWrite: Long = 0

    @Value("\${cache.caffeine.expire-after-write-unit}")
    private lateinit var expireAfterWriteUnit: String

    @Bean
    fun caffeineCacheManager(): CacheManager {
        val expireUnit = TimeUnit.valueOf(expireAfterWriteUnit)

        val caffeine = Caffeine.newBuilder()
            .maximumSize(maximumSize)
            .expireAfterWrite(expireAfterWrite, expireUnit)
        val cacheManager = CaffeineCacheManager()
        cacheManager.setCaffeine(caffeine)
        return cacheManager
    }
}
