package com.fonseca.lucas.encripty.service.impl

import com.fonseca.lucas.encripty.dto.EncryptDTO
import com.fonseca.lucas.encripty.service.EncryptService
import org.springframework.stereotype.Service
import java.nio.ByteBuffer
import java.security.SecureRandom
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

@Service
class EncryptServiceImpl: EncryptService {

    override fun encryptByValueAndKey(value: String, key: String): EncryptDTO {

        val iv = ByteArray(16)
        SecureRandom().nextBytes(iv)

        val secretKey = SecretKeySpec(key.toByteArray(Charsets.UTF_8), "AES")

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, IvParameterSpec(iv))

        val cipherText = cipher.doFinal(value.toByteArray())

        val byteBuffer = ByteBuffer.allocate(4 + iv.size + cipherText.size)
        byteBuffer.putInt(iv.size)
        byteBuffer.put(iv)
        byteBuffer.put(cipherText)

        val cipherMessage = byteBuffer.array()

        return EncryptDTO(String(Base64.getEncoder().encode(cipherMessage)))
    }

    override fun decryptByValueAndKey(value: String, key: String): String {
        val cipherMessage = Base64.getDecoder().decode(value)
        val byteBuffer = ByteBuffer.wrap(cipherMessage)
        val messageIvLength = byteBuffer.int
        if (messageIvLength != 16) {
            throw IllegalArgumentException("Invalid iv length")
        }
        val iv = ByteArray(messageIvLength)
        byteBuffer.get(iv)
        val cipherText = ByteArray(byteBuffer.remaining())
        byteBuffer.get(cipherText)

        val secretKey = SecretKeySpec(key.toByteArray(), "AES")

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, secretKey, IvParameterSpec(iv))

        return String(cipher.doFinal(cipherText))
    }
}
