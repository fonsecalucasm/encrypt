package com.fonseca.lucas.encripty.controller

import com.fonseca.lucas.encripty.dto.EncryptRequestDTO
import com.fonseca.lucas.encripty.service.EncryptService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EncryptController {

    @Autowired
    lateinit var encryptService: EncryptService

    @PostMapping("/encrypt")
    fun getEncrypt(@RequestBody body: EncryptRequestDTO): Any {
        return ResponseEntity.ok(encryptService.encryptByValueAndKey(body.value, body.key))
    }

    @PostMapping("/decrypt")
    fun decrypt(@RequestBody body: EncryptRequestDTO): Any {
        return ResponseEntity.ok(encryptService.encryptByValueAndKey(body.value, body.key))
    }
}
