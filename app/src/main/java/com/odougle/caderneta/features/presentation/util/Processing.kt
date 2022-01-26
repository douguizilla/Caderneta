package com.odougle.caderneta.features.presentation.util

fun calculateFinishDate(date: String, portionCount : Int) : String{
    var day = getDay(date)
    var month = getMonth(date)
    var year = getYear(date)

    var newMonth = month.toInt()
    var newYear = year.toInt()

    for (i in 0..portionCount-1){
        if(newMonth < 12){
            newMonth++
        }else{
            newMonth = 1
            newYear++
        }
    }
    return "$day/${newMonth}/${newYear}"
}

fun getDay(date: String) = "${date[0]}${date[1]}"
fun getMonth(date: String) = "${date[3]}${date[4]}"
fun getYear(date: String) = "${date[6]}${date[7]}${date[8]}${date[9]}"