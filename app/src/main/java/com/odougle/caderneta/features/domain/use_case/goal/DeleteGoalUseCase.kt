package com.odougle.caderneta.features.domain.use_case.goal

import com.odougle.caderneta.features.domain.model.Goal
import com.odougle.caderneta.features.domain.repository.DatabaseRepository

class DeleteGoalUseCase(
    private val repository: DatabaseRepository
) {
    suspend operator fun invoke(goal: Goal){
        repository.deleteGoal(goal)
    }
}