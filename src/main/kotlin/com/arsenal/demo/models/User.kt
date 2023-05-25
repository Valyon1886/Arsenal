package com.arsenal.demo.models

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter
import org.hibernate.internal.util.collections.CollectionHelper.listOf

@Entity
@Table(name="myusers")  // Таблица пользователей
data class User(
    @Column var idToken: String?,
    @Column var userName: String?,  // Никнейм пользователя
//    @Column(nullable = false) val password: String,  // Пароль пользователя (хранится в шифрованном виде)
    @Column var image: String?,  // Аватар пользователя
    @Column var role: String?,  // Роль пользователя (user или admin)
    @ManyToMany @Column var arsenal: MutableList<Blaster>?,  // Список оборудования, добавленных пользователем в арсенал
    @ManyToMany @Column var games: MutableList<Game>?,  // Список игровых сессий, в которых учавствовал пользователь
    @Id @GeneratedValue var id: Long? = null
)
{

    constructor() : this("","",  "", "user", mutableListOf(), mutableListOf())
}

