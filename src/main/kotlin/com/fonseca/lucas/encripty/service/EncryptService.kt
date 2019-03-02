package com.fonseca.lucas.encripty.service

import com.fonseca.lucas.encripty.dto.EncryptDTO

interface EncryptService {
    fun getEncryptByValueAndKey(value: String, key: String): EncryptDTO
}
