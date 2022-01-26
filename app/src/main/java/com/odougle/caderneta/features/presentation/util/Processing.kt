package com.odougle.caderneta.features.presentation.util

fun calculateFinishDate(date: String){
    var day = getDay(date)
    var month = getMonth(date)
    var year = getYear(date)
}

fun getDay(date: String) = "${date[0]}${date[1]}"
fun getMonth(date: String) = "${date[3]}${date[4]}"
fun getYear(date: String) = "${date[6]}${date[7]}${date[8]}${date[9]}"