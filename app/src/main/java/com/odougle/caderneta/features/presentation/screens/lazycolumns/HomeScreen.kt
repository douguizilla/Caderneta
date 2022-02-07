package com.odougle.caderneta.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.odougle.caderneta.features.domain.model.Outlay
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

        val incomeValue = viewModel.calculateIncomes()
        val outlayValue = viewModel.calculateOutlays()

        MoneyBar(income = incomeValue, outlay = outlayValue)

        MoneyBarLabel(income = incomeValue, outlay = outlayValue)

    }
}

@Composable
private fun MoneyBarLabel(income: Double, outlay: Double) {
    Box {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "$income")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "$outlay")
        }
    }
}

@Composable
fun MoneyBar(
    income: Double,
    outlay: Double
) {

    val percentage = if (income > outlay) (outlay * 100 / income) / 100 else 1.0f

    Box{
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .padding(16.dp)
        ) {
            Text("")
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(percentage.toFloat())
                    .background(Color.Red)
                    .padding(16.dp)
            ){
                Text("")
            }
        }
    }
}
