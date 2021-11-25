package com.odougle.caderneta.view.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.odougle.caderneta.R
import com.odougle.caderneta.util.SHAPE
import com.odougle.caderneta.view.screens.bottomSheetDialogs.NewIncome
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun AddItems() {
    val shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(shape)
            .padding(16.dp)
    ) {
        val context = LocalContext.current
        AddBottomSheetItem(
            drawableIconId = R.drawable.ic_income,
            contentDescription = "Adicionar receita",
            spacerHeight = 16.dp,
            addAction = { addIncome() }
        )

        AddBottomSheetItem(
            drawableIconId = R.drawable.ic_outlay,
            contentDescription = "Adicionar despesa",
            spacerHeight = 16.dp,
            addAction = { addOverlay() }
        )

        AddBottomSheetItem(
            drawableIconId = R.drawable.ic_goals,
            contentDescription = "Adicionar meta",
            spacerHeight = 16.dp,
            addAction = { addGoal() }
        )

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

@ExperimentalMaterialApi
@Composable
fun addIncome() {
    val bottomState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = bottomState,
        sheetShape = SHAPE,
        sheetContent = {
            NewIncome()
        }
    ){
        coroutineScope.launch {
            bottomState.show()
        }
    }
}

fun addOverlay() {

}

fun addGoal() {

}

