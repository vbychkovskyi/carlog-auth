package ua.com.vbychkovskyi.carlog.auth.dao

import java.time.LocalDateTime

data class Token(
        val userUid: String,
        val token: String,
        val id: String? = null,
        val createdDate: LocalDateTime = LocalDateTime.now()
)