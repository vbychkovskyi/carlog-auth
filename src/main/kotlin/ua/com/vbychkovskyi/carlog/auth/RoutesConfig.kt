package ua.com.vbychkovskyi.carlog.auth

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class RoutesConfig {

    @Bean
    fun routerFunction(handler: TokenHandler): RouterFunction<ServerResponse> {
        return router {
            GET("/token/{token}", handler::getToken)
            POST("/token", handler::createToken)
        }
    }
}