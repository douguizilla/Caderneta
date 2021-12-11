package com.odougle.caderneta.model

data class Goal(
    val tag: String = "meta",
    val description: String,
    val total: Double,
    val portion: Double,
    val quantity: Int,
    val paid: Int,
    val billingDate: Int,
    val creationDate: String,
    val finishDate: String
)
