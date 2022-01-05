package com.odougle.caderneta.features.domain.use_case

import com.odougle.caderneta.features.domain.use_case.goal.AddGoalUseCase
import com.odougle.caderneta.features.domain.use_case.goal.DeleteGoalUseCase
import com.odougle.caderneta.features.domain.use_case.goal.GetGoalUseCase
import com.odougle.caderneta.features.domain.use_case.goal.GetGoalsUseCase
import com.odougle.caderneta.features.domain.use_case.income.AddIncomeUseCase
import com.odougle.caderneta.features.domain.use_case.income.DeleteIncomeUseCase
import com.odougle.caderneta.features.domain.use_case.income.GetIncomeUseCase
import com.odougle.caderneta.features.domain.use_case.income.GetIncomesUseCase
import com.odougle.caderneta.features.domain.use_case.outlay.AddOutlayUseCase
import com.odougle.caderneta.features.domain.use_case.outlay.DeleteOutlayUseCase
import com.odougle.caderneta.features.domain.use_case.outlay.GetOutlayUseCase
import com.odougle.caderneta.features.domain.use_case.outlay.GetOutlaysUseCase

data class CadernetaUseCases(
    val addGoalUseCase: AddGoalUseCase,
    val addIncomeUseCase: AddIncomeUseCase,
    val addOutlayUseCase: AddOutlayUseCase,
    val deleteGoalUseCase: DeleteGoalUseCase,
    val deleteIncomeUseCase: DeleteIncomeUseCase,
    val deleteOutlayUseCase: DeleteOutlayUseCase,
    val getGoalUseCase: GetGoalUseCase,
    val getGoalsUseCase: GetGoalsUseCase,
    val getIncomeUseCase: GetIncomeUseCase,
    val getIncomesUseCase: GetIncomesUseCase,
    val getOutlayUseCase: GetOutlayUseCase,
    val getOutlaysUseCase: GetOutlaysUseCase
)
