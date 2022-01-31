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
import com.odougle.caderneta.features.domain.model.Outlay
import com.odougle.caderneta.features.presentation.components.TextField.DateTextField
import com.odougle.caderneta.features.presentation.navigation.BottomBarScreen
import com.odougle.caderneta.features.presentation.screens.CadernetaViewModel
import com.odougle.caderneta.features.presentation.util.DEFAULT_PADDING
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun NewOutlay(
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
        var tagText by remember { mutableStateOf("") }
        var descriptionText by remember { mutableStateOf("") }
        var valueText by remember { mutableStateOf("") }
        var dateText : MutableState<String> = remember{ mutableStateOf("")}

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Adicione uma nova despesa",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = tagText,
            onValueChange = { tagText = it },
            label = { Text(text = "Tag") }
        )

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
                label = { Text(text = "Valor") }
            )

            Spacer(modifier = Modifier.width(16.dp))

            DateTextField(
                modifier = Modifier.weight(1f),
                textValue = dateText,
                label = { Text(text = "Data")}
            )

        }

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
                    val outlay = Outlay(
                        tag = tagText,
                        description = descriptionText,
                        date = dateText.value,
                        value = valueText
                    )

                    viewModel.addOutlay(outlay)

                    navController.navigate(BottomBarScreen.Outlay.route)

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