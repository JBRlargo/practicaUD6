package com.dam.api.controllers

import com.dam.api.models.User
import com.dam.api.services.UsersServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
// Todas las peticiones que lleguen a "/api/v1/productos"
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
class UsersController {
    @Autowired
    lateinit var servicio: UsersServiceImpl

    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<User>> {
        return ResponseEntity(servicio.all, HttpStatus.OK)
    }

    @GetMapping("/{nick}")
    fun getUser(@PathVariable nick: String): ResponseEntity<User> {
        val user: User? = servicio.getByNick(nick)
        if(user != null) {
            return ResponseEntity(user, HttpStatus.OK)
        }
        return ResponseEntity(null, HttpStatus.NOT_FOUND)
    }

    @PostMapping("/")
    fun insertUser(@RequestBody user: User): ResponseEntity<String> {
        val userComprobation = servicio.save(user)
        return if(userComprobation != null) {
            ResponseEntity("Usuario registrado", HttpStatus.CREATED)
        } else {
            ResponseEntity("Usuario no registrado", HttpStatus.NOT_ACCEPTABLE)
        }
    }

    @PutMapping("/{nick}")
    fun updateUser(@PathVariable nick: String, @RequestBody user: User): ResponseEntity<String> {

        val userUpdated: User? = servicio.updateUser(nick, user)
        if(userUpdated != null) {
            return ResponseEntity("Usuario modificado", HttpStatus.OK)
        }
        return ResponseEntity("Usuario no modificado", HttpStatus.NOT_ACCEPTABLE)
    }

    @DeleteMapping("/{nick}")
    fun deleteUser(@PathVariable nick: String): ResponseEntity<String> {
        val deleted = servicio.deleteUser(nick)
        if(deleted) {
            return ResponseEntity("Borrado", HttpStatus.ACCEPTED)
        }
        return ResponseEntity("No se encuentra o no se ha podido borrar", HttpStatus.NOT_ACCEPTABLE)
    }

}