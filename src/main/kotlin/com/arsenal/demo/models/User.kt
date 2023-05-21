package com.arsenal.demo.models

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter
import org.hibernate.internal.util.collections.CollectionHelper.listOf

@Entity
@Table(name="myusers")  // Таблица пользователей
data class User(
    @Column var idToken: String?,
    @Column(nullable = false) var userName: String,  // Никнейм пользователя
    @Column(nullable = false) val password: String,  // Пароль пользователя (хранится в шифрованном виде)
    @Column(nullable = true) var image: String?,  // Аватар пользователя
    @Column(nullable = true) var role: Role,  // Роль пользователя (user или admin)
    @OneToMany @Column(nullable = true) var arsenal: MutableList<Blaster>?,  // Список оборудования, добавленных пользователем в арсенал
    @OneToMany @Column(nullable = true) var games: MutableList<Game>?,  // Список игровых сессий, в которых учавствовал пользователь
    @Id @GeneratedValue var id: Long? = null
)
{

    constructor() : this("","", "", "", Role.UNAUTHORIZED, mutableListOf(), mutableListOf())
}

