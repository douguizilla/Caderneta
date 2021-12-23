package com.odougle.caderneta.features.domain.use_case.outlay

import com.odougle.caderneta.features.domain.model.Outlay
import com.odougle.caderneta.features.domain.repository.DatabaseRepository

class DeleteOutlayUseCase(
    private val repository: DatabaseRepository
) {
    suspend operator fun invoke(outlay: Outlay){
        repository.deleteOutlay(outlay)
    }
}