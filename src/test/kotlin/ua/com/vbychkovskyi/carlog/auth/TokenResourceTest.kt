package ua.com.vbychkovskyi.carlog.auth

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient


class TokenResourceTest : AbstractIntegrationTest() {

    @Autowired
    private val webClient: WebTestClient? = null

    @Test
    fun token() {
        webClient!!.post()
                .uri("/token")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody("{\n"
                        + "  \"token\" : \"abc\",\n"
                        + "  \"userUid\" : 250\n"
                        + "}")
                .exchange()
                .expectStatus()
                .isOk

        webClient.get()
                .uri("/token/abc")
                .exchange()
                .expectStatus()
                .isOk
                .expectBody()
                .jsonPath("$.userUid", "250").hasJsonPath()
                .jsonPath("$.token", "abc").hasJsonPath()
    }
}