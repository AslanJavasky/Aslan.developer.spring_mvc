package com.aslanjavasky.hogwartslibrary.model

import org.springframework.stereotype.Component

/**
 * @author Aslan Javasky, Java/Kotlin developer, Telegram messanger:@Aslan_Javasky
 */
data class Book (

    val name:String = "",
    val author:String = ""

){
    constructor():this("","")
}