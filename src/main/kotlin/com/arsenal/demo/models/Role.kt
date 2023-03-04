package com.arsenal.demo.models

import jakarta.persistence.Table

@Table(name="role")
enum class Role {
    ZOMBIE_STRIKE, ELITE, NSTRIKE, MODULUS, RIVAL, DOOMLANDS // TODO: дописать роли
}