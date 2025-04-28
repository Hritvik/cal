package com.vik.cal

import com.mongodb.client.model.Filters.eq
import com.mongodb.kotlin.client.coroutine.MongoClient
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import org.bson.Document
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = ["com.vik.cal.db.repositories"])
class CalorieCounterApplication

fun main(args: Array<String>) {
	runApplication<CalorieCounterApplication>(*args)
//	warmupMongo()
}

private fun warmupMongo() {
	val uri = "mongodb+srv://cal:cal@vik.ftcozq9.mongodb.net/vik?retryWrites=true&w=majority&ssl=true&appName=vik"
	val mongoClient = MongoClient.create(uri)
	val database = mongoClient.getDatabase("sample_mflix")
	val collection = database.getCollection<Document>("movies")
	runBlocking {
		val doc = collection.find(eq("title", "Back to the Future")).firstOrNull()
		if (doc != null) {
			println(doc.toJson())
		} else {
			println("No matching documents found.")
		}
	}
	mongoClient.close()
}
