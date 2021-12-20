package com.odougle.caderneta.domain.model

import androidx.room.Entity

@Entity(tableName = "outlay")
data class Outlay(
    val tag: String,
    val description: String,
    val date: String,
    val value: String,
)