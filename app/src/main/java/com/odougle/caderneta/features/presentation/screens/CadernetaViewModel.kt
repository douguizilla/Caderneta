package com.odougle.caderneta.features.presentation.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odougle.caderneta.features.domain.model.Income
import com.odougle.caderneta.features.domain.use_case.CadernetaUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class CadernetaViewModel @Inject constructor(
    private val cadernetaUseCases: CadernetaUseCases
) : ViewModel() {

    private var _incomes : MutableState<List<Income>> = mutableStateOf(listOf())
    val incomes : State<List<Income>> = _incomes

    init {
        getIncomes()
    }

    fun addIncome(income: Income) {
        viewModelScope.launch {
            cadernetaUseCases.addIncomeUseCase(income)
        }
    }

    fun deleteIncome(income: Income){
        viewModelScope.launch {
            cadernetaUseCases.deleteIncomeUseCase(income)
        }
    }

    fun getIncomes(){
        viewModelScope.launch {
            cadernetaUseCases.getIncomesUseCase().collect { list ->
                _incomes.value = list
            }
        }
    }

    fun getIncome(id: Int) = runBlocking {
        cadernetaUseCases.getIncomeUseCase(id = id)
    }

}