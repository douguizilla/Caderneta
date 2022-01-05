package com.odougle.caderneta.features.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "goal")
data class Goal(
    val description: String,
    val total: Double,
    val portion: Double,
    val quantity: Int,
    val paid: Int,
    val billingDate: Int,
    val creationDate: String,
    val finishDate: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
