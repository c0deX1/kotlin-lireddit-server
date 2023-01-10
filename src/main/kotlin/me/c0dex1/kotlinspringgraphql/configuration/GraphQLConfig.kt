package me.c0dex1.kotlinspringgraphql.configuration

import graphql.GraphQL
import graphql.execution.AsyncExecutionStrategy
import graphql.schema.GraphQLSchema
import io.leangen.graphql.GraphQLSchemaGenerator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class GraphQLConfig {

//    @Bean
//    fun graphQLSchema(operations: List<GraphQLOperation>): GraphQLSchema {
//        val graphQLSchemaGenerator = GraphQLSchemaGenerator()
//            .withBasePackages("me.c0dex1.kotlinspringgraphql.model")
//        operations.forEach {
//            graphQLSchemaGenerator.withOperationsFromSingletons(it)
//        }
//        return graphQLSchemaGenerator
//            .generate()
//    }
//
//    @Bean
//    fun graphQL(graphQLSchema: GraphQLSchema): GraphQL {
//        return GraphQL.newGraphQL(graphQLSchema)
//            .queryExecutionStrategy(AsyncExecutionStrategy())
////            .instrumentation(CustomTracingInstrumentation())
//            .build()
//    }
//
//    interface GraphQLOperation
}