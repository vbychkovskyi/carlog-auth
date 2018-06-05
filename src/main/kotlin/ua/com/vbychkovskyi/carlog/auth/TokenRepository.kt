package ua.com.vbychkovskyi.carlog.auth

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface TokenRepository : ReactiveMongoRepository<Token, Int> {
    fun findByToken(token: String): Mono<Token>
}