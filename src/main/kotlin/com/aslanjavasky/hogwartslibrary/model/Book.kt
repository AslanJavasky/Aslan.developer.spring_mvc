package com.aslanjavasky.hogwartslibrary.model

import org.springframework.stereotype.Component

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
data class Book(
    var id: Long = 0,
    var name: String = "",
    var author: String = ""

) {
    companion object{
        private var currentId:Long=0
    }

    init {
        id=currentId++
    }
}