package com.example.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class CloudConfigClientApplication

fun main(args: Array<String>) {
    runApplication<CloudConfigClientApplication>(*args)
}

@Component
@ConfigurationProperties("sample")
object SampleProperties {
    lateinit var message: String
    lateinit var encryptedMessage: String
}