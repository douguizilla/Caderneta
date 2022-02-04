package com.odougle.caderneta.features.presentation.screens

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odougle.caderneta.features.domain.model.Goal
import com.odougle.caderneta.features.domain.model.Income
import com.odougle.caderneta.features.domain.model.Outlay
import com.odougle.caderneta.features.domain.use_case.CadernetaUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
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

    private var _outlays : MutableState<List<Outlay>> = mutableStateOf(listOf())
    val outlays : State<List<Outlay>> = _outlays

    private var _goals : MutableState<List<Goal>> = mutableStateOf(listOf())
    val goals : State<List<Goal>> = _goals

    var selectedIncomes : MutableState<MutableList<Income>> = mutableStateOf(mutableListOf())

    var selectedIncomesCount : MutableState<Int> = mutableStateOf(0)
    //val selectedIncomesCount = _selectedIncomesCount

    init {
        getIncomes()
        getOutlays()
        getGoals()
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

    fun getIncome(id: Int) = runBlocking {
        cadernetaUseCases.getIncomeUseCase(id = id)
    }

    fun getIncomes(){
        viewModelScope.launch {
            cadernetaUseCases.getIncomesUseCase().collect { list ->
                _incomes.value = list
            }
        }
    }

    fun getOutlay(id: Int) = runBlocking {
        cadernetaUseCases.getOutlayUseCase(id = id)
    }

    fun addOutlay(outlay: Outlay) {
        viewModelScope.launch {
            cadernetaUseCases.addOutlayUseCase(outlay)
        }
    }

    fun deleteOutlay(outlay: Outlay){
        viewModelScope.launch {
            cadernetaUseCases.deleteOutlayUseCase(outlay)
        }
    }

    fun getOutlays(){
        viewModelScope.launch {
            cadernetaUseCases.getOutlaysUseCase().collect { list ->
                _outlays.value = list
            }
        }
    }

    fun getGoal(id: Int) = runBlocking {
        cadernetaUseCases.getGoalUseCase(id = id)
    }

    fun addGoal(goal: Goal) {
        viewModelScope.launch {
            cadernetaUseCases.addGoalUseCase(goal)
        }
    }

    fun deleteGoal(goal: Goal){
        viewModelScope.launch {
            cadernetaUseCases.deleteGoalUseCase(goal)
        }
    }

    fun getGoals(){
        viewModelScope.launch {
            cadernetaUseCases.getGoalsUseCase().collect { list ->
                _goals.value = list
            }
        }
    }

    fun selectIncome(income: Income){
        selectedIncomes.value.add(income)
        selectedIncomesCount.value++
    }

    fun unselectIncome(income: Income){
        selectedIncomes.value.remove(income)
        selectedIncomesCount.value--
    }

    fun calculateIncomes(): Double {
        val incomes = _incomes.value
        var sum = 0.0
        for(income in incomes){
            sum += income.value.toDouble()
        }
        return sum
    }

    fun calculateOutlays() : Double{
        val outlays = _outlays.value
        var sum = 0.0
        for(outlay in outlays){
            sum += outlay.value.toDouble()
        }
        return sum
    }
}

