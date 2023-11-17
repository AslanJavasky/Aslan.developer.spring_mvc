package com.aslanjavasky.hogwartslibrary.repository

import com.aslanjavasky.hogwartslibrary.model.Book
import org.springframework.stereotype.Repository

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
@Repository
class BookRepositoryImpl : BookRepository {

    private val books = mutableListOf<Book>(
        Book("History of Magic", "Bathilda Bagshot"),
        Book("Fantastic Beasts: Where to Find It", "Newt Scamander"),
        Book("The Theory of Magic", "Adalbert Waffling")
    )


    override fun getAllBooks() = books

    override fun saveBook(book: Book) {
        books.add(book)
    }
}