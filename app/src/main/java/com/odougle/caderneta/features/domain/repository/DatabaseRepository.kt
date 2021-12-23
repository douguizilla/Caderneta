package com.odougle.caderneta.features.domain.repository

import com.odougle.caderneta.features.domain.model.Goal
import com.odougle.caderneta.features.domain.model.Income
import com.odougle.caderneta.features.domain.model.Outlay
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    //GOAL
    suspend fun getGoals(): Flow<List<Goal>>
    suspend fun getGoalById(id: Int) : Goal?
    suspend fun insertGoal(note: Goal)
    suspend fun deleteGoal(note: Goal)

    //INCOME
    suspend fun getIncomes() : Flow<List<Income>>
    suspend fun getIncomeById(id: Int) : Income?
    suspend fun insertIncome(income: Income)
    suspend fun deleteIncome(income: Income)

    //OUTLAY
    suspend fun getOutlays() : Flow<List<Outlay>>
    suspend fun getOutlayById(id: Int) : Outlay?
    suspend fun insertOutlay(outlay: Outlay)
    suspend fun deleteOutlay(outlay: Outlay)

}