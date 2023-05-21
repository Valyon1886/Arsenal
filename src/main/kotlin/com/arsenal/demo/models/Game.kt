package com.arsenal.demo.models

import jakarta.persistence.*
import org.hibernate.internal.util.collections.CollectionHelper

@Entity
@Table(name="game")  //  Таблица игровых сеансов
data class Game  (
    @Column(nullable = false) var name: String,  // Название игрового сеанса
    @Column(nullable = true)  var amount: Int,  // Минимальное количество участников
    @Column(nullable = true) var image: String,  // Иконка игрового сеанса
    @Column(nullable = false) var mode: Mode,  // Игровой режим (правила игрового сеанса)
    @OneToMany
//    @Column(nullable = true) var arsenals: MutableList<MutableList<Blaster>>?,  // Список
    @Column(nullable = true) var users: MutableList<User>?,  // Список
    @Id @GeneratedValue var id: Long? = null
)
{
    constructor() : this("",  1, "", Mode.CLASSIC_THIRD, mutableListOf())
}