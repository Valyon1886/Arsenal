package com.arsenal.demo.models

import jakarta.persistence.*

@Entity
@Table(name="game")
data class Game  (
    @Column(nullable = false) var name: String,
    @Column(nullable = true)  var amount: Int,
    @Column(nullable = true) var image: String,
    @Column(nullable = false) var mode: Mode,
    @Id @GeneratedValue var id: Long? = null){

    constructor() : this("",  1, "", Mode.CLASSIC_THIRD)
}