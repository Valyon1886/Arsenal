package com.arsenal.demo.models

import jakarta.persistence.*
import org.hibernate.internal.util.collections.CollectionHelper.listOf

@Entity
@Table(name="blaster")  //  Таблица предметов (бластеров)
data class Blaster(
    @Column(nullable = false) var name: String,  // Название бластера
    @OneToMany @Column(nullable = false)  var ammo: List<Ammo>, // Список используемых типов боеприпасов                       // map колличество патронов в сумме (в описании говорится сколько конкретно чего)
    @Column(nullable = false)  var amount: Int,  //  Количество боеприпасов
    @Column(nullable = true) var image: String,  //  Изображение бластера (отображается в каталоге)
    @Column(nullable = true) var series: Series,  //  Название серии к которой принадлежит бластер
    @Column(nullable = false) var category: String,//Category,
    @Column(nullable = false) var author: String,  //  Ник пользователя, добавившего бластер (поумолчанию админ)
    @Id @GeneratedValue var id: Long? = null
)
{

    constructor() : this("", listOf(), 1, "", Series.ZOMBIE_STRIKE, "", "", null)
}