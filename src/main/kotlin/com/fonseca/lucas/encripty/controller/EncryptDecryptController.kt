package com.fonseca.lucas.encripty.controller

import com.fonseca.lucas.encripty.dto.EncryptRequestDTO
import com.fonseca.lucas.encripty.service.EncryptDecryptService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EncryptDecryptController {

    @Autowired
    lateinit var encryptDecryptService: EncryptDecryptService

    @PostMapping("/encrypt")
    fun getEncrypt(@RequestBody body: EncryptRequestDTO): Any {
        return ResponseEntity.ok(encryptDecryptService.getEncryptByValueAndKey(body.value, body.key))
    }

    @PostMapping("/decrypt")
    fun getDecrypted(@RequestBody body: EncryptRequestDTO): Any {
        return ResponseEntity.ok(encryptDecryptService.getDecryptedTextByValueAndKey(body.value, body.key))
    }
}
