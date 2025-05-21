package com.vik.cal.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Cal")
                    .description("API documentation for Cal")
                    .version("1.0.0")
                    .contact(Contact().name("Hritvik Dinkar").email("hritvikdinkar@gmail.com"))
            )
    }
}
