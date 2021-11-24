package com.odougle.caderneta.view.screens.bottomSheetDialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun NewIncome() {
    Column(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(16.dp)
    ) {
        var text by remember { mutableStateOf("")}

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {text = it},
            label = { Text(text = "Descrição")}
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {text = it},
            label = { Text(text = "Valor")}
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {text = it},
            label = { Text(text = "Data")}
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
               modifier = Modifier.weight(1f),
                onClick = { }
            ) {
                Text(text = "CANCELAR")
            }

            Spacer(modifier = Modifier.width(8.dp))
            Button(
                modifier = Modifier.weight(1f),
                onClick = { }
            ) {
                Text(text = "ADICIONAR")
            }


        }


    }
}

