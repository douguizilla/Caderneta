package com.odougle.caderneta.features.data.data_source

import androidx.room.*
import com.odougle.caderneta.features.domain.model.Goal
import com.odougle.caderneta.features.domain.model.Income
import com.odougle.caderneta.features.domain.model.Outlay
import kotlinx.coroutines.flow.Flow

@Dao
interface DatabaseDao {
    //GOAL
    @Query("SELECT * FROM goal")
    suspend fun getGoals(): Flow<List<Goal>>

    @Query("SELECT * FROM goal WHERE id = :id")
    suspend fun getGoalById(id: Int) : Goal?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGoal(note: Goal)

    @Delete
    suspend fun deleteGoal(note: Goal)

    //INCOME
    @Query("SELECT * FROM income")
    suspend fun getIncomes() : Flow<List<Income>>

    @Query("SELECT * FROM income WHERE id = :id")
    suspend fun getIncomeById(id: Int) : Income?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIncome(income: Income)

    @Delete
    suspend fun deleteIncome(income: Income)

    //OUTLAY
    @Query("SELECT * FROM outlay")
    suspend fun getOutlays() : Flow<List<Outlay>>

    @Query("SELECT * FROM outlay WHERE id = :id")
    suspend fun getOutlayById(id: Int) : Outlay?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOutlay(outlay: Outlay)

    @Delete
    suspend fun deleteOutlay(outlay: Outlay)
}