package me.c0dex1.kotlinspringgraphql.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User(
    @Id var id: Int,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
    var username: String,
    var password: String
)