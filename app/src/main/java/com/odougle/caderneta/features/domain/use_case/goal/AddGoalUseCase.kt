package com.odougle.caderneta.features.domain.use_case.goal

import com.odougle.caderneta.features.domain.model.Goal
import com.odougle.caderneta.features.domain.repository.DatabaseRepository

class AddGoalUseCase(
    private val repository: DatabaseRepository
) {
    suspend operator fun invoke(goal: Goal){
        repository.insertGoal(goal)
    }
}