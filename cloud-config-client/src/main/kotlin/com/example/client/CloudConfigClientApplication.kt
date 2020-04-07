package com.example.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import javax.servlet.http.HttpServletRequest

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

@RestController
class RefreshController {

    @PostMapping("/refresh")
    fun refresh(request: HttpServletRequest) = RestTemplate().postForEntity(
        request.requestURL.toString().replace(request.requestURI, "/actuator/bus-refresh"),
        HttpEntity("", HttpHeaders().apply {
            this.add(HttpHeaders.CONTENT_TYPE, "application/json")
        }),
        String::class.java
    )
}