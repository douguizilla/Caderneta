package com.odougle.caderneta.features.presentation.screens.bottomSheetDialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.odougle.caderneta.features.domain.model.Goal
import com.odougle.caderneta.features.presentation.components.TextField.DateTextField
import com.odougle.caderneta.features.presentation.navigation.BottomBarScreen
import com.odougle.caderneta.features.presentation.screens.CadernetaViewModel
import com.odougle.caderneta.features.presentation.util.DEFAULT_PADDING
import com.odougle.caderneta.features.presentation.util.calculateFinishDate
import com.odougle.caderneta.features.presentation.util.getDay
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun NewGoal(
    navController: NavHostController,
    bottomSheetState: ModalBottomSheetState,
    viewModel: CadernetaViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(DEFAULT_PADDING)
    ) {
        var descriptionText by remember { mutableStateOf("") }
        var valueText by remember { mutableStateOf("") }
        var portionValueText by remember { mutableStateOf("") }
        var billingDateText: MutableState<String> = remember { mutableStateOf("") }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Adicione uma nova meta",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = descriptionText,
            onValueChange = { descriptionText = it },
            label = { Text(text = "Descri????o") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = valueText,
                onValueChange = { valueText = it },
                label = { Text(text = "Valor total") }
            )

            Spacer(modifier = Modifier.width(16.dp))

            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = portionValueText,
                onValueChange = { portionValueText = it },
                label = { Text(text = "Valor parcela") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        DateTextField(
            modifier = Modifier.fillMaxWidth(),
            textValue = billingDateText,
            label = { Text(text = "Data") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    coroutineScope.launch {
                        bottomSheetState.hide()
                    }
                }
            ) {
                Text(text = "CANCELAR")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    val quantity = (valueText.toDouble() / portionValueText.toDouble()).toInt()
                    val billingDate =
                        getDay(billingDateText.value).toInt()
                    val finishDate = calculateFinishDate(billingDateText.value, quantity)
                    val goal = Goal(
                        description = descriptionText,
                        total = valueText.toDouble(),
                        portion = portionValueText.toDouble(),
                        quantity = quantity,
                        paid = 0,
                        billingDate = billingDate,
                        creationDate = billingDateText.value,
                        finishDate = finishDate //need to calculabe by quantity
                    )

                    viewModel.addGoal(goal)

                    navController.navigate(BottomBarScreen.Goals.route)

                    coroutineScope.launch {
                        bottomSheetState.hide()
                    }
                }
            ) {
                Text(text = "ADICIONAR")
            }

        }
    }
}