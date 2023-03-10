package com.dam.api.services

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Producto
import com.dam.api.repositories.ProductosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class ProductosServiceImpl : ProductosServiceAPI, GenericServiceImpl<Producto, Long>() {
    //private val productos = mutableListOf("Cafe", "Agua", "Cerveza")

    @Autowired
    lateinit var productosRepository: ProductosRepository

    override val dao: CrudRepository<Producto, Long>
        get() = productosRepository

    /*val dao: CrudRepository<Producto, Long>
        get() {
            return productosRepository
        }
    fun getAll(): MutableList<Producto> {
        val returnList: MutableList<Producto> = ArrayList()
        dao.findAll().forEach(Consumer { obj: Producto -> returnList.add(obj) })
        return returnList
    }

    fun getOne(productoId:Long):Producto? {
        *//*var algo = productos.find { it.lowercase() == producto.lowercase() }
        println(algo)*//*
        return dao.findByIdOrNull(productoId)
    }

    fun addProduct(producto: Producto):Producto? {
        val productoCreado = dao.save(producto)
        return if(getOne(productoCreado.id) != null) {
            productoCreado
        } else{
            null
        }
    }

    fun borrarProducto(productoId: Long):Boolean {
        val producto = getOne(productoId)
        if(producto != null) {
            dao.delete(producto)
            getOne(producto.id) ?: return true
        }
        return false
    }*/

    fun modificarProducto(producto: Producto): Boolean {
        val productoComprobacion = get(producto.id)
        if(productoComprobacion != null) {
            val productoModificado = dao.save(producto)
            println("Producto: ${producto.id}, ${producto.nombre}")
            println("Producto Modificado: ${productoModificado.id}, ${productoModificado.nombre}")
            if(producto === productoModificado) {
                return true
            }
            println("No son iguales")
        }
        return false
    }
}