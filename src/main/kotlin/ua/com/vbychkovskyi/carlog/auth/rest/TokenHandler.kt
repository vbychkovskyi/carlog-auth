package ua.com.vbychkovskyi.carlog.auth.rest

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import ua.com.vbychkovskyi.carlog.auth.facade.TokenFacade
import ua.com.vbychkovskyi.carlog.auth.rest.dto.TokenDto

@Component
class TokenHandler(private val facade: TokenFacade) {

    fun getToken(request: ServerRequest): Mono<ServerResponse> {
        val pathVariable = request.pathVariable("token")

        return ServerResponse.ok()
                .body(facade.findByToken(pathVariable), TokenDto::class.java)
    }

    fun createToken(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().body(request.bodyToMono(TokenDto::class.java)
                .flatMap { facade.create(it) }, TokenDto::class.java)
    }
}