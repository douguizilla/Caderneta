package com.odougle.caderneta.view.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.odougle.caderneta.view.screens.bottomSheetDialogs.NewIncome
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun AddItems() {
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    val content: @Composable (() -> Unit) = { Text("NULL") }
    var customSheetContent by remember { mutableStateOf(content) }
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            customSheetContent()
        }
    ) {
        Column {
            Button(
                onClick = {
                    customSheetContent = { NewIncome() }
                    scope.launch { bottomSheetState.show() }
                }) {
                Text("First Button")
            }

        }
    }
}

@Composable
fun AddBottomSheetItem(
    drawableIconId: Int,
    contentDescription: String,
    spacerHeight: Dp,
    addAction: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = true) {
                addAction
            }

    ){
        Icon(painter = painterResource(id = drawableIconId), contentDescription = contentDescription)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = contentDescription)
    }
    Spacer(modifier = Modifier.height(spacerHeight))
}