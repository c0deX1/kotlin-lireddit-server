package me.c0dex1.kotlinspringgraphql.repository

import me.c0dex1.kotlinspringgraphql.model.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Int>
