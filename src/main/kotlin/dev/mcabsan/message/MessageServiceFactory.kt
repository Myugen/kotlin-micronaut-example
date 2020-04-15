package dev.mcabsan.message

import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Property
import javax.inject.Singleton

@Factory
class MessageServiceFactory(@Property(name = "hello.message", defaultValue = "Hello") private val message: String) {

    @Singleton
    fun messageService(): MessageService = MessageService.instance(message);
}