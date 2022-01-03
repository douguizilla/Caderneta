package com.odougle.caderneta.features.domain.use_case.income

import com.odougle.caderneta.features.domain.model.Income
import com.odougle.caderneta.features.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow

class GetIncomeUseCase (
    private val repository: DatabaseRepository
)
{
    operator fun invoke() : Flow<List<Income>>{
        return repository.getIncomes()
    }
}