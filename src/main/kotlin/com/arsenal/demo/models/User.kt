package com.arsenal.demo.models

import jakarta.persistence.*

@Table(name="user")
data class User(
    @Column(nullable = false) val userName: String,
    @Column(nullable = false) val password: String,
    @Column(nullable = true) val image: String,
    @Column(nullable = true) val role: Role,
    @Column(nullable = true) val arsenal: List<Blaster>,
    @Id @GeneratedValue var id: Long? = null
)