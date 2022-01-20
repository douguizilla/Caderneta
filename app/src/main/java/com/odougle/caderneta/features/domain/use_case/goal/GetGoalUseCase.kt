package com.odougle.caderneta.features.domain.use_case.goal

import com.odougle.caderneta.features.domain.model.Goal
import com.odougle.caderneta.features.domain.model.Income
import com.odougle.caderneta.features.domain.repository.DatabaseRepository

class GetGoalUseCase(
    private val repository: DatabaseRepository
) {
    suspend operator fun invoke(id: Int): Goal?{
        return repository.getGoalById(id)
    }
}