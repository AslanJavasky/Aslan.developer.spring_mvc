package com.aslanjavasky.hogwartslibrary.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.util.logging.Logger

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
    fun regular(request:HttpServletRequest): String {
        val nameOfBook=request.getParameter("bookname")
        val author=request.getParameter("author")
        Logger.getLogger(LibraryController::class.java.name).info("The author:$author and name of Book is $nameOfBook")
        return "regular_section"
    }


    @GetMapping("/secret") //lib/secret
    fun secter()="secret_section"


}