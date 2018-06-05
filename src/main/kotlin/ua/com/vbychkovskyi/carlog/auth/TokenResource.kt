package ua.com.vbychkovskyi.carlog.auth

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@RestController
class TokenResource(private val repository: TokenRepository) {

    @GetMapping(value = ["/token/{token}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun token(@PathVariable("token") token: String): Mono<Token> {
        return repository.findByToken(token)
    }

    @PostMapping(value = ["/token"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun saveToken(@RequestBody token: Mono<Token>): Mono<Token> {
        return token
                .map { Token(it.id, it.token, LocalDateTime.now()) }
                .flatMap { repository.save(it) }
    }
}