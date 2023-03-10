package com.dam.api.controllers

import com.dam.api.models.Producto
import com.dam.api.services.ProductosServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
// Todas las peticiones que lleguen a "/api/v1/productos"
@RequestMapping("/api/v1/productos")
@CrossOrigin("*")
class ProductosController {
    // URL -> /api/v1/productos/
    @Autowired
    lateinit var servicio: ProductosServiceImpl

    @GetMapping("/")
    fun getAll(): ResponseEntity<MutableList<Producto>> {
        return ResponseEntity(servicio.all, HttpStatus.OK)
    }

    @GetMapping("/{productoId}")
    fun getProducto(@PathVariable productoId:String): ResponseEntity<Producto> {
        val id = productoId.toLongOrNull()
        if(id != null) {
            val producto = servicio[id]
            if(producto != null) {
                return ResponseEntity(producto, HttpStatus.OK)
            }
        }
        return ResponseEntity(null, HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/{productoId}")
    fun borrarProducto(@PathVariable productoId: String) : ResponseEntity<String> {
        val id = productoId.toLongOrNull()
        if(id != null) {
            servicio.delete(id)
            return ResponseEntity("Borrado", HttpStatus.OK)
        }
        return ResponseEntity("No se encuentra o no se ha podido borrar", HttpStatus.NOT_FOUND)
    }

    @PostMapping("/")
    fun insertProducto(@RequestBody producto: Producto): ResponseEntity<String> {
        val productoComprobacion = servicio.save(producto)
        return if(productoComprobacion != null) {
            ResponseEntity("Producto introducido", HttpStatus.OK)
        } else {
            ResponseEntity("Producto no introducido", HttpStatus.I_AM_A_TEAPOT)
        }
    }

    @PutMapping("/")
    fun modificarProducto(@RequestBody producto: Producto): ResponseEntity<String> {
        val productoComprobacion = servicio.modificarProducto(producto)
        if(productoComprobacion) {
            return ResponseEntity("Producto modificado", HttpStatus.OK)
        }
        return ResponseEntity("Producto no modificado", HttpStatus.I_AM_A_TEAPOT)
    }
}