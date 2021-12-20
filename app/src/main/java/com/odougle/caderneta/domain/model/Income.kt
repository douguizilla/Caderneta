package com.odougle.caderneta.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "income")
data class Income(
    val tag: String,
    val description: String,
    val date: String,
    val value: String,
    @PrimaryKey val id: Int? = null
)
