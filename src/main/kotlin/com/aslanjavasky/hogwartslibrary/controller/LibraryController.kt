package com.aslanjavasky.hogwartslibrary.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
@Controller
@RequestMapping("lib")
class LibraryController {

    //GET, PUT, POST, DELETE, PATCH
    @GetMapping("/welcome")
//    @RequestMapping(method = [RequestMethod.GET], value = ["lib/welcome"])
    fun welcome()= "hello"


    @GetMapping("/regular") //lib/regular
    fun regular()="regular_section"


    @GetMapping("/secret") //lib/secret
    fun secter()="secret_section"


}