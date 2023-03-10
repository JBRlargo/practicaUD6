package com.dam.api.models

import jakarta.persistence.*

@Entity
@Table(name="users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(name = "nick", unique = true)
    var nick: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "password", nullable = true)
    var password: String?,

    @Column(name = "profile_picture")
    var profilePicture: String,
) {

}