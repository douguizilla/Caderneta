package com.odougle.caderneta.view.screens.bottomSheetDialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun NewIncome(
    bottomSheetState: ModalBottomSheetState
) {
    val coroutine = rememberCoroutineScope()
    Column(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(16.dp)
    ) {
        var descriptionText by remember { mutableStateOf("")}
        var valueText by remember { mutableStateOf("")}
        var dateText by remember { mutableStateOf("")}

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = descriptionText,
            onValueChange = {descriptionText = it},
            label = { Text(text = "Descrição")}
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = valueText,
            onValueChange = {valueText = it},
            label = { Text(text = "Valor")}
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = dateText,
            onValueChange = {dateText = it},
            label = { Text(text = "Data")}
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
               modifier = Modifier.weight(1f),
                onClick = {
                    coroutine.launch {
                        bottomSheetState.hide()
                    }
                }
            ) {
                Text(text = "CANCELAR")
            }

            Spacer(modifier = Modifier.width(16.dp))
            Button(
                modifier = Modifier.weight(1f),
                onClick = { }
            ) {
                Text(text = "ADICIONAR")
            }

        }


    }
}

