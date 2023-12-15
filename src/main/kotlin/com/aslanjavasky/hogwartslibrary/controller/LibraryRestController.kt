package com.aslanjavasky.hogwartslibrary.controller

import com.aslanjavasky.hogwartslibrary.model.BookEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.awt.print.Book

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
@RestController
class LibraryRestController {

    @GetMapping("/lib/rest/string")
//    @ResponseBody
    fun someRestString() = "Some rest string!"


    @GetMapping("/lib/rest/book")
    fun someRestBook() = ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .header("genre", "Fantasy")
        .header("programmer's name", "Aslan")
        .body(BookEntity(1, "The Lord of the Rings", "J.R.R. Tolkien", 2020))

    @GetMapping("/lib/rest/books")
    fun someRestBooks() = ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .body(
            listOf<BookEntity>(
                BookEntity(1, "The Lord of the Rings", "J.R.R. Tolkien", 2020),
                BookEntity(name = "The Hobbit", author = "J.R.R. Tolkien", yearOfPublication = 2020),
                BookEntity(name = "Pride and Prejudice", author = "Jane Austen", yearOfPublication = 2020),
                BookEntity(name = "The Da Vinci Code", author = "Dan Brown", yearOfPublication = 2020),
            )
        )


}