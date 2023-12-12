package com.aslanjavasky.hogwartslibrary

import com.aslanjavasky.hogwartslibrary.model.BookEntity
import com.aslanjavasky.hogwartslibrary.repository.BookRepositoryJpa
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
@Component
class DataLoader(
    @Autowired val repo:BookRepositoryJpa
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        repo.saveAll(listOf(
            BookEntity(name = "To Kill a Mockingbird", author = "Harper Lee", yearOfPublication = 2020),
            BookEntity(name = "1984", author = "George Orwell", yearOfPublication = 2020),
            BookEntity(name = "The Great Gatsby", author = "F. Scott Fitzgerald", yearOfPublication = 2020),
            BookEntity(name = "The Catcher in the Rye", author = "J.D. Salinger", yearOfPublication = 2020),
            BookEntity(name = "Harry Potter and the Sorcerer's Stone", author = "J.K. Rowling", yearOfPublication = 2020),
            BookEntity(name = "The Lord of the Rings", author = "J.R.R. Tolkien", yearOfPublication = 2020),
            BookEntity(name = "The Hobbit", author = "J.R.R. Tolkien", yearOfPublication = 2020),
            BookEntity(name = "Pride and Prejudice", author = "Jane Austen", yearOfPublication = 2020),
            BookEntity(name = "The Da Vinci Code", author = "Dan Brown", yearOfPublication = 2020),
            BookEntity(name = "The Hunger Games", author = "Suzanne Collins", yearOfPublication = 2020),
            BookEntity(name = "The Shining", author = "Stephen King", yearOfPublication = 2020),
            BookEntity(name = "The Alchemist", author = "Paulo Coelho", yearOfPublication = 2020),
            BookEntity(name = "The Girl with the Dragon Tattoo", author = "Stieg Larsson", yearOfPublication = 2020),
            BookEntity(name = "The Chronicles of Narnia", author = "C.S. Lewis", yearOfPublication = 2020)

        ))
    }
}