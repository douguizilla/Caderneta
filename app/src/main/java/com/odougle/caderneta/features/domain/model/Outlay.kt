package com.odougle.caderneta.features.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "outlay")
data class Outlay(
    val tag: String,
    val description: String,
    val date: String,
    val value: String,
    @PrimaryKey(autoGenerate = true) val id: Int
)