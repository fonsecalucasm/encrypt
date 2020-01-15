package com.fonseca.lucas.encripty.service

import com.fonseca.lucas.encripty.dto.EncryptDTO

interface EncryptDecryptService {
    fun getEncryptByValueAndKey(value: String, key: String): EncryptDTO
    fun getDecryptedTextByValueAndKey(value: String, key: String): String
}
