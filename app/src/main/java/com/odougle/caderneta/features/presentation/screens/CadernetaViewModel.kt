package com.odougle.caderneta.features.presentation.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odougle.caderneta.features.domain.model.Income
import com.odougle.caderneta.features.domain.use_case.CadernetaUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CadernetaViewModel @Inject constructor(
    private val cadernetaUseCases: CadernetaUseCases
) : ViewModel() {

    private val _state = mutableStateOf(Income())
    val state: State<Income> = _state

    fun addIncome(income: Income) {
        viewModelScope.launch {
            cadernetaUseCases.addIncomeUseCase(income)
        }
    }
}