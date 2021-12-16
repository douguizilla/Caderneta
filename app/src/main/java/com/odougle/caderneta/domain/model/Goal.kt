package com.odougle.caderneta.domain.model

data class Goal(
    val description: String,
    val total: Double,
    val portion: Double,
    val quantity: Int,
    val paid: Int,
    val billingDate: Int,
    val creationDate: String,
    val finishDate: String
)
