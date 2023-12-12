package com.aslanjavasky.hogwartslibrary.service

import com.aslanjavasky.hogwartslibrary.model.Book
import org.springframework.stereotype.Service

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
@Service
interface BookDbService {
    fun getAllBooks(): MutableList<Book>
    fun getBookById(id:Long): Book
    fun saveBook(book:Book)
    fun updateBookById(id: Long, book: Book)
    fun deleteBookById(id:Long)
}