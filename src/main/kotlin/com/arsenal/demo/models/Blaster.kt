package com.arsenal.demo.models

import jakarta.persistence.*

@Entity
@Table(name="blaster")
data class Blaster(
    @Column(nullable = false) var name: String,
    @OneToMany @Column(nullable = false)  var ammo: List<Ammo>,  // map колличество патронов в сумме (в описании говорится сколько конкретно чего)
    @Column(nullable = false)  var amount: Int,
    @Column(nullable = true) var image: String,
    @Column(nullable = true) var series: Series,
    @Column(nullable = false) var category: String,//Category,
    @Column(nullable = false) var author: String,
    @Id @GeneratedValue var id: Long? = null){

    constructor() : this("", listOf(), 1, "", Series.ZOMBIE_STRIKE, "", "", null)
}