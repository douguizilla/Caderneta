package com.odougle.caderneta.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.odougle.caderneta.features.domain.model.Goal
import com.odougle.caderneta.features.presentation.screens.CadernetaViewModel
import com.odougle.caderneta.features.presentation.screens.lazycolumns.items.GoalItem

@Composable
fun GoalsScreen(
    viewModel: CadernetaViewModel = hiltViewModel()
) {
    val goalsList = viewModel.goals.value
//    val goalsList = listOf(
//        Goal("Viagem", 1000.0, 100.0, 10,2, 10, "10/11/2021", "10/01/2022"),
//        Goal("Carro", 1000.0, 100.0, 10,2, 10, "10/11/2021", "10/01/2022"),
//        Goal("Dentista", 1000.0, 100.0, 10,2, 10, "10/11/2021", "10/01/2022"),
//        Goal("Economia", 1000.0, 100.0, 10,2, 10, "10/11/2021", "10/01/2022"),
//        Goal("Reserva", 1000.0, 100.0, 10,2, 10, "10/11/2021", "10/01/2022"),
//        Goal("Consórcio", 1000.0, 100.0, 10,2, 10, "10/11/2021", "10/01/2022"),
//        Goal("Viagem", 1000.0, 100.0, 10,2, 10, "10/11/2021", "10/01/2022"),
//        Goal("Viagem", 1000.0, 100.0, 10,2, 10, "10/11/2021", "10/01/2022"),
//        Goal("Viagem", 1000.0, 100.0, 10,2, 10, "10/11/2021", "10/01/2022")
//    )
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        items(goalsList) { goal ->
            GoalItem(
                description = goal.description,
                total = goal.total,
                portion = goal.portion,
                quantity = goal.quantity,
                paid = goal.paid,
                billingDate = goal.billingDate,
                creationDate = goal.creationDate,
                finishDate = goal.finishDate
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

//val description: String,
//val total: Double,
//val portion: Double,
//val quantity: Int,
//val paid: Int,
//val billingDate: Int,
//val creationDate: String,
//val finishDate: String