package com.aslanjavasky.hogwartslibrary.repository

import com.aslanjavasky.hogwartslibrary.model.Book
import org.springframework.stereotype.Repository

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
@Repository
interface BookRepository {
    fun getAllBooks(): MutableList<Book>
    fun saveBook(book:Book)
}