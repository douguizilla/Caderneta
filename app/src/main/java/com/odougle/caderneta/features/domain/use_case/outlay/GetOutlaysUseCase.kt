package com.odougle.caderneta.features.domain.use_case.outlay

import com.odougle.caderneta.features.domain.model.Outlay
import com.odougle.caderneta.features.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow

class GetOutlaysUseCase(
    private val repository: DatabaseRepository
) {
    operator fun invoke() : Flow<List<Outlay>>{
        return repository.getOutlays()
    }
}