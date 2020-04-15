package dev.mcabsan.message

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class MessageControllerTest(@Client("/") private val client: RxHttpClient) : BehaviorSpec({
    given("the message endpoint") {
        `when`("GET /message/hello/Miguel") {
            val response: HttpResponse<String> = client.toBlocking().exchange("/message/hello/Miguel", String::class.java)
            then("Response status is OK") {
                response.status shouldBe HttpStatus.OK
            }
            then("Response body is Hello Miguel") {
                response.body() shouldBe "Hello Miguel"
            }
        }
    }
})