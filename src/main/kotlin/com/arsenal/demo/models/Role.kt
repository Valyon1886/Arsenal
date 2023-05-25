package com.arsenal.demo.models

import jakarta.persistence.*

@Table(name="role")
enum class Role {
    USER, ADMIN, UNAUTHORIZED // TODO: дописать роли
}