package ua.com.vbychkovskyi.carlog.auth.facade

import reactor.core.publisher.Mono
import ua.com.vbychkovskyi.carlog.auth.rest.dto.TokenDto

interface TokenFacade {
    fun findByToken(token: String): Mono<TokenDto>

    fun create(tokenDto: TokenDto): Mono<TokenDto>
}