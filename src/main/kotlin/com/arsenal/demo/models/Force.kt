package com.arsenal.demo.models

import jakarta.persistence.Table


@Table(name="category")
enum class Category {
    ZOMBIE_STRIKE, ELITE, NSTRIKE, MODULUS, RIVAL, DOOMLANDS // TODO: дописать степени сложности (не для детей и другие специальные метки)
}