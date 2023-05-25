package com.arsenal.demo.models

import jakarta.persistence.*
import org.hibernate.internal.util.collections.CollectionHelper

@Entity
@Table(name="game")  //  Таблица игровых сеансов
data class Game  (
    @Column(nullable = false) var name: String,  // Название игрового сеанса
    @Column(nullable = true)  var amount: Int?,  // Минимальное количество участников
    @Column(nullable = true) var image: String?,  // Иконка игрового сеанса
    @Column(nullable = false) var mode: String,  // Игровой режим (правила игрового сеанса)
    @Column(nullable = true) var description: String?,
    @Column(nullable = true) var destination: String?,
    @Column(nullable = true) var allowedSeries: MutableList<String?>,
    @Column(nullable = true) var data: String?,
//    @Column(nullable = true) var arsenals: MutableList<MutableList<Blaster>>?,  // Список
    @Column(nullable = true) var users: MutableList<Long>?,  // Список
    @Column(nullable = true) var isActive: Boolean,
    @Id @GeneratedValue var id: Long? = null
)
{
    constructor() : this("",  1, "", "CLASSIC_THIRD", "", "", mutableListOf(), "", mutableListOf(), true)
}