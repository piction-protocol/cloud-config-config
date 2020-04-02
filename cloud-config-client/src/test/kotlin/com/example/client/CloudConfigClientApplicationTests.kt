package com.example.client

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CloudConfigClientApplicationTests {

    @Test
    fun samplePropertiesMessageIsEqualToStaging() {
        Assertions.assertThat(SampleProperties.message).isEqualTo("staging!")
    }
}
