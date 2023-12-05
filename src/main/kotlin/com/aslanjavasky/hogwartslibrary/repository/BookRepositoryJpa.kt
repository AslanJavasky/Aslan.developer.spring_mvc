package com.aslanjavasky.hogwartslibrary.repository

import com.aslanjavasky.hogwartslibrary.model.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepositoryJpa : JpaRepository<BookEntity,Long>