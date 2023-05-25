package com.arsenal.demo.models

import jakarta.persistence.*


@Entity
@Table(name="ammo")  //  Таблица типов боеприпасов
data class Ammo (
        @Column(nullable = true) var ammoName: String?,  //  Название типа боеприпасов
        @Id @GeneratedValue var id: Long? = null
)
{

    constructor() : this("")
}