package com.dam.api.controllers

import com.dam.api.models.Movie
import com.dam.api.services.MoviesServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin("*")
class MoviesController {
    @Autowired
    lateinit var servicio: MoviesServiceImpl

    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Movie>> {
        println("Hola, estoy llegando aquí")
        return ResponseEntity(servicio.all, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getMovie(@PathVariable id: String): ResponseEntity<Movie> {
        val movieId = id.toLongOrNull()
        if (movieId != null) {
            val movie = servicio[movieId]
            if (movie != null) {
                return ResponseEntity(movie, HttpStatus.OK)
            }
        }
        return ResponseEntity(null, HttpStatus.NOT_FOUND)
    }
}