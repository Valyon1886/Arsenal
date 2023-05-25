package com.arsenal.demo.models

import jakarta.persistence.*
import org.hibernate.internal.util.collections.CollectionHelper


@Table(name="mode")
enum class Mode {
    CLASSIC_THIRD, BASE_ON_BASE, CHAOS, CUSTOM
}