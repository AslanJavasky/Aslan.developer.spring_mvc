package com.aslanjavasky.hogwartslibrary.repository

import com.aslanjavasky.hogwartslibrary.model.Book
import org.springframework.stereotype.Repository

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
@Repository
class BookRepositoryImpl : BookRepository {

    //C(create)R(read)U(update)D(delete)

    private val books = mutableListOf(
        Book(name="History of Magic", author="Bathilda Bagshot"),
        Book(name="Fantastic Beasts: Where to Find It", author="Newt Scamander"),
        Book(name="The Theory of Magic", author="Adalbert Waffling")
    )


    override fun getAllBooks() = books

    override fun getBookById(id: Long): Book {
        return books.find { it.id==id } ?: Book(name="", author = "")
    }

    override fun saveBook(book: Book) {
        books.add(book)
    }

    override fun updateBookById(id: Long, book: Book) {
        books.find { it.id==id }?.let {
            it.name=book.name
            it.author=book.author
        }
    }

    override fun deleteBookById(id: Long) {
        books.removeIf{ it.id == id}
    }
}

