package com.odougle.caderneta.features.presentation.screens

import androidx.lifecycle.ViewModel
import com.odougle.caderneta.features.domain.use_case.CadernetaUseCases
import javax.inject.Inject

class CadernetaViewModel @Inject constructor(
    private val cadernetaUseCases: CadernetaUseCases
) : ViewModel(){

}