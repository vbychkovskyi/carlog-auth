package ua.com.vbychkovskyi.carlog.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class CarlogAuthApplication

fun main(args: Array<String>) {
    runApplication<CarlogAuthApplication>(*args)
}
