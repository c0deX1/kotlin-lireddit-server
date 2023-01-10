package me.c0dex1.kotlinspringgraphql.model

import io.leangen.graphql.annotations.GraphQLId
import io.leangen.graphql.annotations.GraphQLInputField
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Post(
    @GraphQLId @Id var id: Int,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
    @GraphQLInputField var title: String?
)