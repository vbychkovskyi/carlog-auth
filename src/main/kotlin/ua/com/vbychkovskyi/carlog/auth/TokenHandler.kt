package ua.com.vbychkovskyi.carlog.auth

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Component
class TokenHandler(private val repository: TokenRepository) {

    fun getToken(request: ServerRequest): Mono<ServerResponse> {
        val pathVariable = request.pathVariable("token")

        return ServerResponse.ok()
                .body(repository.findByToken(pathVariable), Token::class.java)
    }

    fun createToken(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().body(request.bodyToMono(Token::class.java)
                .map { Token(it.id, it.token, LocalDateTime.now()) }
                .flatMap { repository.save(it) }, Token::class.java)
    }
}