package com.dam.api.controllers


import com.dam.api.models.Session
import com.dam.api.services.SessionsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/sessions")
@CrossOrigin("*")
class SessionsController {
    @Autowired
    lateinit var servicio: SessionsServiceImpl

    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Session>> {
        return ResponseEntity(servicio.all, HttpStatus.OK)
    }

    @GetMapping("/sincetoday")
    fun getSessionsSinceToday(): ResponseEntity<MutableList<Session>> {
        val sessionSinceToday: MutableList<Session> = servicio.sinceToday()
        if (sessionSinceToday.size > 0) {
            return ResponseEntity(sessionSinceToday, HttpStatus.OK)
        }
        return ResponseEntity(null, HttpStatus.NOT_FOUND)
    }

    @GetMapping("/today")
    fun getSessionsToday(): ResponseEntity<MutableList<Session>> {
        val sessionToday: MutableList<Session> = servicio.today()
        if (sessionToday.size > 0) {
            return ResponseEntity(sessionToday, HttpStatus.OK)
        }
        return ResponseEntity(null, HttpStatus.NOT_FOUND)
    }
}