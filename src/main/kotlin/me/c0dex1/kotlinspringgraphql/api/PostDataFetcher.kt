package me.c0dex1.kotlinspringgraphql.api

import io.leangen.graphql.annotations.GraphQLArgument
import io.leangen.graphql.annotations.GraphQLMutation
import io.leangen.graphql.annotations.GraphQLQuery
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi
import me.c0dex1.kotlinspringgraphql.model.Post
import me.c0dex1.kotlinspringgraphql.repository.PostRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
@GraphQLApi
class PostDataFetcher(private val postRepository: PostRepository) {
    val posts = mutableMapOf<Int, Post>()
    var counter = 0

    @GraphQLQuery
    fun posts(): Collection<Post> = posts.values

    @GraphQLMutation
    fun post(@GraphQLArgument(name = "title") title: String): Post? {
        val id = ++counter
        posts[id] = Post(id, LocalDateTime.now(), LocalDateTime.now(), title)
        return posts[id]
    }
}