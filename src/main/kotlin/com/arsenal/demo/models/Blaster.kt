package com.arsenal.demo.models

import jakarta.persistence.*

enum class Series{
    ZOMBIE_STRIKE, ELITE, NSTRIKE, MODULUS, RIVAL, DOOMLANDS // TODO: дописать серии
}

//@Entity
//@Table(name="blaster")
//data class Blaster(id: Long, name: String, ammo ): {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    val id: Long,
//
//    @Column(nullable = false)
//    val name: String,
//
//    @Column(nullable = false)
//    val ammo = mutableListOf<Ammo>(),
////    val ammo: List<Ammo>,
//
//    @Column(nullable = true)
//    val picture: String,
//
//    @Column(nullable = true)
//    val series: Series,
//
//    @Column(nullable = false)
//    val author: String
//
//}