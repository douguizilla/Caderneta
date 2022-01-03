package com.odougle.caderneta.features.domain.use_case.goal

import com.odougle.caderneta.features.domain.model.Goal
import com.odougle.caderneta.features.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow

class GetGoalsUseCase(
    private val repository: DatabaseRepository
) {
    operator fun invoke() : Flow<List<Goal>>{
        return repository.getGoals()
    }
}