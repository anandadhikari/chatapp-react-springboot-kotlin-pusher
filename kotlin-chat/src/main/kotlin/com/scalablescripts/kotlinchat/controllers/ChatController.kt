package com.scalablescripts.kotlinchat.controllers

import com.pusher.rest.Pusher
import com.scalablescripts.kotlinchat.dtos.MessageDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("api")
class ChatController {

    @PostMapping("/messages")
    fun message(@RequestBody body: MessageDTO): ResponseEntity<Any> {
        val pusher = Pusher("1009040", "95499a330306e4be6f62", "3e1a7deb53023fc86c3e")
        pusher.setCluster("ap2")
        pusher.setEncrypted(true)
        pusher.trigger("chat", "message", Collections.singletonMap("message", body))

        return ResponseEntity.ok(emptyArray<String>())
    }
}