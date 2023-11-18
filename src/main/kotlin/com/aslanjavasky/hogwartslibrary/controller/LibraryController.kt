package com.aslanjavasky.hogwartslibrary.controller

import com.aslanjavasky.hogwartslibrary.model.Book
import com.aslanjavasky.hogwartslibrary.repository.BookRepository
import com.aslanjavasky.hogwartslibrary.repository.BookRepositoryImpl
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import java.util.logging.Logger

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
@Controller
@RequestMapping("lib")
class LibraryController(
    @Autowired val repo: BookRepository
) {

    //GET, PUT, POST, DELETE, PATCH
    @GetMapping("/welcome/{color}")
//    @RequestMapping(method = [RequestMethod.GET], value = ["lib/welcome"])
    fun welcome(
        @RequestParam(value = "name", required = false) name: String?,
        @RequestParam(value = "lastname", required = false) lastname: String?,
        @PathVariable("color") textColor: String,
        model: Model
    ): String {
        if (!name.isNullOrBlank() && !lastname.isNullOrBlank()) {
            model.addAttribute("name", name)
            model.addAttribute("lastname", lastname)
//            model.addAttribute("h1_text", "HOGWARTS LIBRARY")
        }
        model.addAttribute("text_color", textColor)
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
    fun regular(model: Model): String {
        model.addAttribute("books", repo.getAllBooks())
        model.addAttribute("book",Book())
//        model.addAttribute("h1_text", "HOGWARTS LIBRARY")
        return "regular_section"
    }

    @PostMapping("/regular") //lib/regular
    fun createNewBook(
        @ModelAttribute("book") book: Book,
        model: Model
    ): String {
        repo.saveBook(book)
        model.addAttribute("books", repo.getAllBooks())
        return "regular_section"
    }


    @GetMapping("/secret") //lib/secret
    fun secret(model: Model): String {
//        model.addAttribute("h1_text", "HOGWARTS LIBRARY")
        return "secret_section"
    }

    @ModelAttribute("h1_text")
    fun addTextForHead1() = "HOGWARTS LIBRARY"


}