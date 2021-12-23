package com.odougle.caderneta.features.data.data_source

import androidx.room.*
import com.odougle.caderneta.features.domain.model.Goal
import kotlinx.coroutines.flow.Flow

@Dao
interface GoalDao {
    @Query("SELECT * FROM goal")
    suspend fun getGoals(): Flow<List<Goal>>

    @Query("SELECT * FROM goal WHERE id = :id")
    suspend fun getGoalById(id: Int) : Goal?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGoal(note: Goal)

    @Delete
    suspend fun deleteGoal(note: Goal)
}