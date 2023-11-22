package com.aslanjavasky.hogwartslibrary

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
class HogwartslibraryApplication

fun main(args: Array<String>) {
	runApplication<HogwartslibraryApplication>(*args)
}

//M(Model)V(View)C(Controller)
