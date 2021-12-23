package com.odougle.caderneta.features.data.data_source

import androidx.room.*
import com.odougle.caderneta.features.domain.model.Income
import kotlinx.coroutines.flow.Flow

@Dao
interface IncomeDao {

    @Query("SELECT * FROM income")
    suspend fun getIncomes() : Flow<List<Income>>

    @Query("SELECT * FROM income WHERE id = :id")
    suspend fun getIncomeById(id: Int) : Income?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIncome(income: Income)

    @Delete
    suspend fun deleteIncome(income: Income)
}