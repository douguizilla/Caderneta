package com.odougle.caderneta.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "outlay")
data class Outlay(
    val tag: String,
    val description: String,
    val date: String,
    val value: String,
    @PrimaryKey val id: Int? = null
)