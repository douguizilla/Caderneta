package com.odougle.caderneta.features.domain.use_case.income

import com.odougle.caderneta.features.domain.model.Income
import com.odougle.caderneta.features.domain.model.Outlay
import com.odougle.caderneta.features.domain.repository.DatabaseRepository

class DeleteIncomeUseCase(
    private val repository: DatabaseRepository
) {
    suspend operator fun invoke(income: Income){
        repository.deleteIncome(income)
    }
}