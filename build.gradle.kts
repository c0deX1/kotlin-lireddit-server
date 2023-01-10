import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    id("org.liquibase.gradle") version "2.0.3"
}


liquibase {
    activities.register("main") {
        this.arguments = mapOf(
            "logLevel" to "debug",
            "changeLogFile" to "db/changelog.xml",
            "url" to "jdbc:postgresql://localhost:5432/lireddit?currentSchema=lireddit",
            "defaultSchemaName" to "lireddit",
            "username" to "c0dex1",
            "referenceUrl" to "hibernate:spring:me.c0dex1.kotlinspringgraphql?" +
                    "dialect=org.hibernate.dialect.PostgreSQL95Dialect" +
                    "&hibernate.physical_naming_strategy=org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy",
        )
    }
    runList = "main"
}

group = "me.c0dex1"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.leangen.graphql:graphql-spqr-spring-boot-starter:0.0.6")
    implementation("com.graphql-java:graphiql-spring-boot-starter:5.0.2")
    liquibaseRuntime("org.springframework.boot:spring-boot-starter-data-jpa")
    liquibaseRuntime("org.liquibase.ext:liquibase-hibernate5:4.18.0")
    liquibaseRuntime("org.liquibase:liquibase-core:4.18.0")
    liquibaseRuntime("org.postgresql:postgresql:42.2.14")
    liquibaseRuntime(sourceSets["main"].output)
//
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework:spring-webflux")
}

tasks {
    diffChangeLog {
        dependsOn(compileJava)
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
