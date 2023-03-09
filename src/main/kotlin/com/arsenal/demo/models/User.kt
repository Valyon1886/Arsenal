package com.arsenal.demo.models

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Table(name="myusers")
data class User(
    @Column(nullable = false) var userName: String,
    @Column(nullable = false) val password: String,
    @Column(nullable = true) var image: String?,
    @Column(nullable = true) var role: Role,
    @OneToMany @Column(nullable = true) var arsenal: List<Blaster>?,
    @Id @GeneratedValue var id: Long? = null
)
{

    constructor() : this("", "", "", Role.UNAUTHORIZED, listOf())
}