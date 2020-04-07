package com.example.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

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

@RestController
class SampleController {

    @GetMapping("/message")
    fun message() = SampleProperties.message
}