package com.dam.api.services

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Session
import com.dam.api.repositories.SessionsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class SessionsServiceImpl : SessionsServiceAPI, GenericServiceImpl<Session, Long>() {

    @Autowired
    lateinit var repository: SessionsRepository

    override val dao: CrudRepository<Session, Long>
        get() = repository

    fun sinceToday(): MutableList<Session> {
        val listSessions : MutableList<Session> = mutableListOf()
        if(this.all != null) {
            for (session: Session in this.all!!) {
                val date = session.date
                if(date != null) {
                    if(date.isEqual(LocalDate.now()) || date.isAfter(LocalDate.now())) {
                        listSessions.add(session)
                    }
                }
            }
        }
        return listSessions
    }

    fun today(): MutableList<Session> {
        val listSessions : MutableList<Session> = mutableListOf()
        if(this.all != null) {
            for (session: Session in this.all!!) {
                val date = session.date
                if(date != null) {
                    if(date.isEqual(LocalDate.now())) {
                        listSessions.add(session)
                    }
                }
            }
        }
        return listSessions
    }
}