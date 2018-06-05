package ua.com.vbychkovskyi.carlog.auth

import java.time.LocalDateTime

data class Token(
        val id: Int,
        val token: String,
        val createdDate: LocalDateTime?
)