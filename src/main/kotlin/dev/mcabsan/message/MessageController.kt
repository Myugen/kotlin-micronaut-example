package dev.mcabsan.message

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.validation.constraints.NotBlank

@Controller("/message")
open class MessageController(private val messageService: MessageService) {

    @Get(value = "/hello/{name}", produces = [MediaType.TEXT_PLAIN])
    open fun sayHello(@NotBlank name: String): String = messageService.sayHello(name);
}