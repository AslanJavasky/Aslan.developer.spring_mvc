package com.aslanjavasky.hogwartslibrary.repository

import com.aslanjavasky.hogwartslibrary.model.*
import org.springframework.stereotype.Repository

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
@Repository("RepoH2")
class BookRepositoryImplForH2(
    private val jpaRepo:BookRepositoryJpa
) : BookRepository{
    override fun getAllBooks(): MutableList<Book> {
        return jpaRepo.findAll().fromEntityList()
    }

    override fun getBookById(id: Long): Book {
        return jpaRepo.findById(id).get().fromEntity()
    }

    override fun saveBook(book: Book) {
        jpaRepo.save(book.toEntity())
    }

    override fun updateBookById(id: Long, book: Book) {
        if (jpaRepo.existsById(id)){
            val existingBook=jpaRepo.findById(id).get().apply {
                name=book.name
                author=book.author
                yearOfPublication=book.yearOfPublication
            }
            jpaRepo.save(existingBook)
        }
    }

    override fun deleteBookById(id: Long) {
        jpaRepo.deleteById(id)
    }

 }