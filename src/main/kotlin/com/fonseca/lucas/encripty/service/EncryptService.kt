package com.fonseca.lucas.encripty.service

import com.fonseca.lucas.encripty.dto.EncryptDTO

interface EncryptService {
    fun encryptByValueAndKey(value: String, key: String): EncryptDTO
    fun decryptByValueAndKey(value: String, key: String): String
}
