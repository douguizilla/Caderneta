package com.odougle.caderneta.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.odougle.caderneta.features.presentation.screens.CadernetaViewModel
import com.odougle.caderneta.features.presentation.util.ALL_SIDES_ROUNDED_CORNER_SHAPE
import com.odougle.caderneta.ui.theme.MyGreen
import org.intellij.lang.annotations.JdkConstants

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    sheetContent: MutableState<(@Composable () -> Unit)>,
    bottomState: ModalBottomSheetState,
    viewModel : CadernetaViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        val modifier = Modifier
            .fillMaxWidth(0.6f)
            .padding(8.dp)


        val incomeValue = viewModel.calculateIncomes()
        val outlayValue = viewModel.calculateOutlays()

        Row(horizontalArrangement = Arrangement.SpaceEvenly){
            Row(modifier = modifier
                .background(MyGreen),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "${incomeValue}")
            }

            Row(modifier = modifier
                .background(Color.Red),
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = "${outlayValue} ")
            }
        }

    }
}

@Preview
@Composable
fun MoneyBar() {
    val income by remember { mutableStateOf("1002")}
    val outlay by remember { mutableStateOf("10")}
    val shape = RoundedCornerShape(20.dp)
    val i = 1002.0
    val o = 10
    val percentage = (o * 100 / i) / 100
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){
                Column {
                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Green)
                        .padding(12.dp)
                    ){
                        Text("")
                    }
                    Row {
                        Text(income)
                    }
                }

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Column {
                    Row (modifier = Modifier
                        .fillMaxWidth(percentage.toFloat())
                        .background(color = Color.Red)
                        .padding(12.dp),
                        horizontalArrangement = Arrangement.End
                    ){
                        Text("")
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth(percentage.toFloat() + 0.05f),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(outlay)
                    }
                }
            }
        }




    }
}