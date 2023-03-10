package com.dam.api.models

import com.fasterxml.jackson.annotation.*
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name="sessions")
class Session(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name="movie_id")
    @JsonManagedReference
    var movie: Movie,

    @Column(name = "room_id")
    var idRoom: Long,

    @Column(name = "date")
    var date: LocalDate?
)