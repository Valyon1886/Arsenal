package com.arsenal.demo.models

import jakarta.persistence.*

@Entity
@Table(name="ammo")
data class Ammo (@Column(nullable = false) var name: String,
                @Id @GeneratedValue var id: Long? = null){

    constructor() : this("")
}