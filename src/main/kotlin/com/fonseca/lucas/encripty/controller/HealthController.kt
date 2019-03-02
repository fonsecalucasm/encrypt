package com.fonseca.lucas.encripty.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {

    @GetMapping("/health")
    fun getHealth(): Any {
        return ResponseEntity.ok("It's Up!")
    }
}
