package com.odougle.caderneta.features.domain.use_case.income

import com.odougle.caderneta.features.domain.model.Income
import com.odougle.caderneta.features.domain.repository.DatabaseRepository

class GetIncomeUseCase (
    private val repository: DatabaseRepository
) {
    suspend operator fun invoke(id: Int): Income?{
        return repository.getIncomeById(id)
    }
}