package com.dam.api.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import jakarta.persistence.*

@Entity
@Table(name="movies")
class Movie(

    @Column(name = "title")
    var title: String,

    @Column(name = "director")
    var director: String,

    @Column(name = "time")
    var time: String,

    @Column(name = "trailer", nullable = true)
    var trailer: String?,

    @Column(name = "poster_image")
    var posterImage: String,

    @Column(name = "screenshot")
    var screenshot: String,



    @Column(name = "synopsis", length = 3000)
    var synopsis: String,

    @OneToMany(mappedBy = "movie", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JsonBackReference
    var sessions: MutableSet<Session>?,


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

)