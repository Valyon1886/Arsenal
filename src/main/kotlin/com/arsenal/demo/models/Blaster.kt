package com.arsenal.demo.models

import jakarta.persistence.*

//@Entity
@Table(name="blaster")
data class Blaster(
    @Column(nullable = false) var name: String,
    @OneToMany @Column(nullable = false)  var ammo: List<Ammo>,
    @Column(nullable = true) var image: String,
    @Column(nullable = true) var series: Series,
    @Column(nullable = false) var author: String,
    @Id @GeneratedValue var id: Long? = null) {

}