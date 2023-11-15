package com.aslanjavasky.hogwartslibrary.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
@Controller
class LibraryController {

    //GET, PUT, POST, DELETE, PATCH
    @GetMapping("lib/welcome")
    fun welcome()= "hello"


    @GetMapping("lib/regular")
    fun regular()="regular_section"


    @GetMapping("lib/secret")
    fun secter()="secret_section"


}