package com.odougle.caderneta.view.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.odougle.caderneta.features.domain.model.Income
import com.odougle.caderneta.features.presentation.screens.CadernetaViewModel
import com.odougle.caderneta.features.presentation.screens.lazycolumns.items.IncomeItem

@Composable
fun IncomeScreen(
    viewModel: CadernetaViewModel = hiltViewModel()
) {
//    val incomeList = listOf(
//        Income("receita", "salario", "10/10/2021", "2.000,00"),
//        Income("receita", "freela", "11/10/2021", "1.000,00"),
//        Income("receita", "bico", "10/11/2021", "2.200,00"),
//        Income("receita", "investimento", "09/10/2021", "5.000,00"),
//        Income("receita", "salario", "07/10/2008", "4.000,00"),
//        Income("receita", "salario", "10/10/2021", "2.000,00"),
//        Income("receita", "freela", "11/10/2021", "1.000,00"),
//        Income("receita", "bico", "10/11/2021", "2.200,00"),
//        Income("receita", "investimento", "09/10/2021", "5.000,00"),
//        Income("receita", "salario", "07/10/2008", "4.000,00"),
//        Income("receita", "salario", "10/10/2021", "2.000,00"),
//        Income("receita", "freela", "11/10/2021", "1.000,00"),
//        Income("receita", "bico", "10/11/2021", "2.200,00"),
//        Income("receita", "investimento", "09/10/2021", "5.000,00"),
//        Income("receita", "salario", "07/10/2008", "4.000,00"),
//    )

    val incomeList = viewModel.incomes.value

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        items(incomeList) { income ->
            IncomeItem(
                tag = income.tag,
                description = income.description,
                date = income.date,
                value = income.value
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}