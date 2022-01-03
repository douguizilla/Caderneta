package com.odougle.caderneta.features.domain.use_case.outlay

import com.odougle.caderneta.features.domain.model.Outlay
import com.odougle.caderneta.features.domain.repository.DatabaseRepository

class GetOutlayUseCase (
    private val repository: DatabaseRepository
) {
    suspend operator fun invoke(id: Int): Outlay?{
        return repository.getOutlayById(id)
    }
}