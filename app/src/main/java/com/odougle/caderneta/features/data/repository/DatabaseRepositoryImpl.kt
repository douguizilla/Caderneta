package com.odougle.caderneta.features.data.repository

import com.odougle.caderneta.features.data.data_source.DatabaseDao
import com.odougle.caderneta.features.domain.model.Goal
import com.odougle.caderneta.features.domain.model.Income
import com.odougle.caderneta.features.domain.model.Outlay
import com.odougle.caderneta.features.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow

class DatabaseRepositoryImpl(
    private val dao: DatabaseDao
) : DatabaseRepository {
    override fun getGoals(): Flow<List<Goal>> {
        return dao.getGoals()
    }

    override suspend fun getGoalById(id: Int): Goal? {
        return dao.getGoalById(id)
    }

    override suspend fun insertGoal(goal: Goal) {
       dao.insertGoal(goal)
    }

    override suspend fun deleteGoal(goal: Goal) {
        dao.deleteGoal(goal)
    }

    override fun getIncomes(): Flow<List<Income>> {
        return dao.getIncomes()
    }

    override suspend fun getIncomeById(id: Int): Income? {
        return dao.getIncomeById(id)
    }

    override suspend fun insertIncome(income: Income) {
        dao.insertIncome(income)
    }

    override suspend fun deleteIncome(income: Income) {
        dao.deleteIncome(income)
    }

    override fun getOutlays(): Flow<List<Outlay>> {
        return dao.getOutlays()
    }

    override suspend fun getOutlayById(id: Int): Outlay? {
        return dao.getOutlayById(id)
    }

    override suspend fun insertOutlay(outlay: Outlay) {
        dao.insertOutlay(outlay)
    }

    override suspend fun deleteOutlay(outlay: Outlay) {
        dao.deleteOutlay(outlay)
    }
}