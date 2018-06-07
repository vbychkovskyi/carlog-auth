package ua.com.vbychkovskyi.carlog.auth.facade

import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import ua.com.vbychkovskyi.carlog.auth.dao.Token
import ua.com.vbychkovskyi.carlog.auth.dao.TokenRepository
import ua.com.vbychkovskyi.carlog.auth.rest.dto.TokenDto

@Component
class DefaultTokenFacade(private val tokenRepository: TokenRepository) : TokenFacade {
    override fun findByToken(token: String): Mono<TokenDto> {
        return tokenRepository.findByToken(token)
                .map { TokenDto(it.userUid, it.token) }
    }

    override fun create(tokenDto: TokenDto): Mono<TokenDto> {
        return Mono.just(tokenDto)
                .map { Token(token = it.token, userUid = it.userUid) }
                .flatMap { tokenRepository.save(it) }
                .map { TokenDto(it.userUid, it.token) }
    }
}