package com.aslanjavasky.hogwartslibrary.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
@Controller
class WelcomeController {

    //GET, PUT, POST, DELETE, PATCH
    @GetMapping("/welcome")
    fun welcome(): String {
        return "hello"
    }

}