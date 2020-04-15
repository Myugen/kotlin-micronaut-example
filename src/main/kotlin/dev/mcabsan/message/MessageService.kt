package dev.mcabsan.message

import io.micronaut.core.util.StringUtils

class MessageService(private val message: String) {
    companion object {
        fun instance(message: String): MessageService = MessageService(message);
    }

    fun sayHello(name: String): String = message.plus(StringUtils.SPACE).plus(name)
}