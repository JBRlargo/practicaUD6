package com.dam.api.services

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.User
import com.dam.api.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class UsersServiceImpl : UsersServiceAPI, GenericServiceImpl<User, Long>() {

    @Autowired
    lateinit var repository: UsersRepository

    override val dao: CrudRepository<User, Long>
        get() = repository

    fun getByNick(nick: String): User? {
        var userFinded: User? = null
        if(this.all != null) {
            for(user: User in this.all!!) {
                if(user.nick == nick) {
                    userFinded = user
                    break
                }
            }
        }
        return userFinded
    }

    fun updateUser(nick: String, user: User): User? {
        val userFinded = getByNick(nick)
        if(userFinded != null) {
            user.id = userFinded.id
            return this.save(user)
        }
        return null
    }

    fun deleteUser(nick: String): Boolean {
        val userFinded = getByNick(nick)
        if (userFinded != null) {
            delete(userFinded.id)
            if(get(userFinded.id) == null) {
                return true
            }
        }
        return false
    }
}