package com.odougle.caderneta.features.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.odougle.caderneta.features.domain.model.Goal
import com.odougle.caderneta.features.domain.model.Income
import com.odougle.caderneta.features.domain.model.Outlay

@Database(
    entities = [Goal::class, Income::class, Outlay::class],
    version = 1
)
abstract class Database: RoomDatabase() {

    companion object{
        const val DATABASE_NAME = "caderneta_db"
    }
}