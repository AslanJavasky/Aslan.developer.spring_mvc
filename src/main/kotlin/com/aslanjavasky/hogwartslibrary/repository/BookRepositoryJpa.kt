package com.aslanjavasky.hogwartslibrary.repository

import com.aslanjavasky.hogwartslibrary.model.BookEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepositoryJpa : JpaRepository<BookEntity,Long>