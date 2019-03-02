package com.fonseca.lucas.encripty.service.impl

import com.fonseca.lucas.encripty.dto.EncryptDTO
import com.fonseca.lucas.encripty.service.EncryptService
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

@Service
class EncryptServiceImpl: EncryptService {

    override fun getEncryptByValueAndKey(value: String, key: String): EncryptDTO {

        val keySpec = SecretKeySpec(key.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING")

        cipher.init(Cipher.ENCRYPT_MODE, keySpec)

        String(Base64.getEncoder().encode(cipher.doFinal(value.toByteArray())))

        return EncryptDTO(String(Base64.getEncoder().encode(cipher.doFinal(value.toByteArray()))))
    }
}
