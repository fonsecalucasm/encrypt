package com.fonseca.lucas.encripty.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ControllerAdvice {

    private val logger = LoggerFactory.getLogger(ControllerAdvice::class.qualifiedName)

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception, request: HttpServletRequest) =
            HttpStatus.INTERNAL_SERVER_ERROR.let {
                logger.error(e.printStackTrace().toString())
                ResponseEntity.status(it).body(StandardError(it.value().toString(), it.reasonPhrase, e.message!!))
            }
}

class StandardError(val statusCode: String, val status: String, val description: String)
