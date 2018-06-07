package ua.com.vbychkovskyi.carlog.auth.dao

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface TokenRepository : ReactiveMongoRepository<Token, String> {
    fun findByToken(token: String): Mono<Token>
}