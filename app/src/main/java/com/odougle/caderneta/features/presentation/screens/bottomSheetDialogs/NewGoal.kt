package com.odougle.caderneta.features.presentation.screens.bottomSheetDialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.odougle.caderneta.features.presentation.util.DEFAULT_PADDING
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun NewGoal(
    bottomSheetState: ModalBottomSheetState
) {
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(DEFAULT_PADDING)
    ) {
        val tagText = "meta"
        var descriptionText by remember { mutableStateOf("") }
        var valueText by remember { mutableStateOf("") }
        var dateText by remember { mutableStateOf("") }
        var billingDate by remember { mutableStateOf("") }

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
            label = { Text(text = "Descrição") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = valueText,
                onValueChange = { valueText = it },
                label = { Text(text = "Valor total") }
            )

            Spacer(modifier = Modifier.width(16.dp))

            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = dateText,
                onValueChange = { dateText = it },
                label = { Text(text = "Valor parcela") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = billingDate,
            onValueChange = { billingDate = it },
            label = { Text(text = "Data primeira cobrança") }
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
                onClick = { }
            ) {
                Text(text = "ADICIONAR")
            }

        }
    }
}