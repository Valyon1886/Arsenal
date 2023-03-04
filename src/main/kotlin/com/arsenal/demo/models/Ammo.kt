package com.arsenal.demo.models

import jakarta.persistence.*

//@Entity
@Table(name="ammo")
data class Ammo (@Column(nullable = false) var name: String,
            @Column(nullable = false) var amount: Int,
            @Id @GeneratedValue var id: Long? = null){

}