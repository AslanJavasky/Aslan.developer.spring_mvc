package com.aslanjavasky.hogwartslibrary.model

import jakarta.validation.constraints.*
//import javax.validation.constraints.Digits
//import javax.validation.constraints.Max
//import javax.validation.constraints.Min
//import javax.validation.constraints.NotEmpty
//import javax.validation.constraints.Size

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
data class Book(
    var id: Long = 0,
    @field:NotEmpty(message = "The book name must be not empty")
    @field:Size(min=2, max = 40, message = "the number of characters must be from 2 to 40")
    var name: String = "",
    @field:NotEmpty(message = "The book author must be not empty")
    var author: String = "",
    @field:Digits(integer = 4, fraction = 0, message = "Invalid year format")
    @field:Min(value=2015, message = "Only modern books!!")
    @field:Max(value=2024, message = "The book has not yet been published" )
    var yearOfPublication: Int = 2012

) {
    companion object{
        private var currentId:Long=0
    }

    init {
        id=currentId++
    }
}