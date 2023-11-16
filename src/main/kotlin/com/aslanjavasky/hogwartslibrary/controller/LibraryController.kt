package com.aslanjavasky.hogwartslibrary.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import java.util.logging.Logger

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
@Controller
@RequestMapping("lib")
class LibraryController {

    //GET, PUT, POST, DELETE, PATCH
    @GetMapping("/welcome/{color}")
//    @RequestMapping(method = [RequestMethod.GET], value = ["lib/welcome"])
    fun welcome(
        @RequestParam(value = "name", required = false) name: String?,
        @RequestParam(value = "lastname", required = false) lastname: String?,
        @PathVariable("color") textColor:String,
        model:Model
    ): String {
        model.addAttribute("name",name)
        model.addAttribute("lastname",lastname)
        model.addAttribute("text_color",textColor)
        return "hello"
    }

    //1)Example with HttpServletRequest
//    @GetMapping("/regular") //lib/regular
//    fun regular(request:HttpServletRequest): String {
//        val nameOfBook=request.getParameter("bookname")
//        val author=request.getParameter("author")
//        Logger.getLogger(LibraryController::class.java.name).info("The author:$author and name of Book is $nameOfBook")
//        return "regular_section"
//    }

    //2)Example with @RequestParam
    @GetMapping("/regular") //lib/regular
    fun regular(
        @RequestParam(value = "bookname", required = false) name: String?,
        @RequestParam(value = "author", required = false) author: String?,
    ): String {
        if (!name.isNullOrBlank() && !author.isNullOrBlank()) {
            Logger.getLogger(LibraryController::class.java.name).info("The author:$author and name of Book is $name")
        }
        return "regular_section"
    }


    @GetMapping("/secret") //lib/secret
    fun secret() = "secret_section"


}