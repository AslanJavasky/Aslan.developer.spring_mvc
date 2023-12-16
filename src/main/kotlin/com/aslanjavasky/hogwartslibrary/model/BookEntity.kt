package com.aslanjavasky.hogwartslibrary.model

import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.springframework.data.rest.core.annotation.RestResource

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
@Entity
@Table(name = "books")
@RestResource(path="books", rel="books")
data class BookEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @field:NotEmpty(message = "The book name must be not empty")
    @field:Size(min = 2, max = 40, message = "the number of characters must be from 2 to 40")
    @Column(name="name_of_book")
    var name: String = "",
    @field:NotEmpty(message = "The book author must be not empty")
    var author: String = "",
    @field:Digits(integer = 4, fraction = 0, message = "Invalid year format")
    @field:Min(value = 2015, message = "Only modern books!!")
    @field:Max(value = 2024, message = "The book has not yet been published")
    var yearOfPublication: Int = 2012,
//    @Enumerated(EnumType.STRING)
//    val genre: Genre=Genre.FICTION

)

fun BookEntity.fromEntity(): Book {
    return Book(
        id = this.id,
        name = this.name,
        author = this.author,
        yearOfPublication = this.yearOfPublication
    )
}

fun Book.toEntity(): BookEntity {
    return BookEntity(
        id = this.id,
        name = this.name,
        author = this.author,
        yearOfPublication = this.yearOfPublication
    )
}

fun MutableList<Book>.toEntityList(): MutableList<BookEntity> {
    return this.map { it.toEntity() }.toMutableList()
}

fun MutableList<BookEntity>.fromEntityList(): MutableList<Book> {
    return this.map { it.fromEntity() }.toMutableList()
}
