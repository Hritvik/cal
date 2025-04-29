package com.vik.cal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = ["com.vik.cal.db.repositories"])
class CalorieCounterApplication

fun main(args: Array<String>) {
	runApplication<CalorieCounterApplication>(*args)
}
