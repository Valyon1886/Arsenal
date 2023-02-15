package com.arsenal.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ArsenalApplication

fun main(args: Array<String>) {
    runApplication<ArsenalApplication>(*args)
}
