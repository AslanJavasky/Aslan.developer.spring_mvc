package com.aslanjavasky.hogwartslibrary.controller

import com.aslanjavasky.hogwartslibrary.model.Book
import com.aslanjavasky.hogwartslibrary.repository.BookRepository
import com.aslanjavasky.hogwartslibrary.repository.BookRepositoryImpl
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PatchMapping
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
    @Autowired @Qualifier("RepoH2") val repo: BookRepository
) {

    //Http Methods:GET, PUT, POST, DELETE, PATCH
    //Html5:GET POST
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
        model.addAttribute("book", Book(name = "", author = "", yearOfPublication = 2020))
//        model.addAttribute("h1_text", "HOGWARTS LIBRARY")
        return "regular_section"
    }

    @PostMapping("/regular") //lib/regular
    fun createNewBook(
        @ModelAttribute("book") @Valid book: Book,
        bindingResult: BindingResult,
        model: Model
    ): String {
        if (bindingResult.hasErrors()) {
            model.addAttribute("books", repo.getAllBooks())
            return "regular_section"
        }
        repo.saveBook(book)
        model.addAttribute("books", repo.getAllBooks())
        return "regular_section"
    }


    @GetMapping("/secret") //lib/secret
    fun secret(model: Model): String {
//        model.addAttribute("h1_text", "HOGWARTS LIBRARY")
        return "secret_section"
    }

    @GetMapping("/edit/{id}")
    fun edit(
        @PathVariable("id") id: Long,
        model: Model
    ): String {
        model.addAttribute("book_for_edit", repo.getBookById(id))
        return "edit_book"
    }

    @PostMapping("/edit/{id}")
    fun update(
        @PathVariable("id") id: Long,
        @ModelAttribute("book_for_edit") @Valid  book: Book,
        bindingResult: BindingResult
    ): String {
        if (bindingResult.hasErrors()){
            return "edit_book"
        }
        repo.updateBookById(id, book)
        return "redirect:/lib/regular"
    }

    @PostMapping("/delete/{id}")
    fun delete(
        @PathVariable("id") id: Long,
    ): String {
        repo.deleteBookById(id)
        return "redirect:/lib/regular"
    }


    @ModelAttribute("h1_text")
    fun addTextForHead1() = "HOGWARTS LIBRARY"


}