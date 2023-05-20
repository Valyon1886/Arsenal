package com.arsenal.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ArsenalApplication

fun main(args: Array<String>) {
    runApplication<ArsenalApplication>(*args)
}

// TODO Сделать modeService с функционалом аналогичным первому приложению
// TODO Заполнить базу данных ориентировочно актуальными данными
//  (как сущность blaswter будет связана с картинкой в firebase)/это нужно?
// храним ссылку на изображение на серваке