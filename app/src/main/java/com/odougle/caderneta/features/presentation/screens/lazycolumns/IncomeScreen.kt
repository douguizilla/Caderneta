package com.odougle.caderneta.view.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.odougle.caderneta.features.domain.model.Income
import com.odougle.caderneta.features.presentation.components.Bar.TopBarType
import com.odougle.caderneta.features.presentation.components.TextField.DateTextField
import com.odougle.caderneta.features.presentation.screens.CadernetaViewModel
import com.odougle.caderneta.features.presentation.screens.lazycolumns.items.IncomeItem
import com.odougle.caderneta.features.presentation.util.ALL_SIDES_ROUNDED_CORNER_SHAPE
import com.odougle.caderneta.features.presentation.util.DEFAULT_PADDING
import com.odougle.caderneta.ui.theme.MyGreen
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun IncomeScreen(
    viewModel: CadernetaViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    sheetContent: MutableState<(@Composable () -> Unit)>,
    bottomState: ModalBottomSheetState,
    topBarState: MutableState<TopBarType>
) {
    val incomeList = viewModel.incomes.value
    val coroutineScope = rememberCoroutineScope()
    var count = 0

//    val incomeList = listOf(
//        Income("receita", "salario", "10/10/2021", "2.000,00",1),
//        Income("receita", "freela", "11/10/2021", "1.000,00",2),
//        Income("receita", "bico", "10/11/2021", "2.200,00"),3,
//        Income("receita", "investimento", "09/10/2021", "5.000,00",4),
//        Income("receita", "salario", "07/10/2008", "4.000,00",5),
//        Income("receita", "salario", "10/10/2021", "2.000,00",6),
//        Income("receita", "freela", "11/10/2021", "1.000,00",7),
//        Income("receita", "bico", "10/11/2021", "2.200,00",8),
//        Income("receita", "investimento", "09/10/2021", "5.000,00",9),
//        Income("receita", "salario", "07/10/2008", "4.000,00",10),
//        Income("receita", "salario", "10/10/2021", "2.000,00",11),
//        Income("receita", "freela", "11/10/2021", "1.000,00",12),
//        Income("receita", "bico", "10/11/2021", "2.200,00",13),
//        Income("receita", "investimento", "09/10/2021", "5.000,00",14),
//        Income("receita", "salario", "07/10/2008", "4.000,00",15),
//    )
    if(incomeList.isEmpty()){
        Box(
            modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Você ainda não possui receita, adicione alguma!")
        }
    }else{
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentPadding = paddingValues
        ) {

            items(incomeList, { income: Income -> income.id }) { income ->
                val dismissState = rememberDismissState()
                if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                    viewModel.deleteIncome(income)
                }
                SwipeToDismiss(
                    state = dismissState,
                    modifier = Modifier
                        .padding(vertical = Dp(1f)),
                    directions = setOf(
                        DismissDirection.EndToStart
                    ),
                    dismissThresholds = { direction ->
                        FractionalThreshold(if (direction == DismissDirection.EndToStart) 0.1f else 0.05f)
                    },
                    background = {
                        Card(shape = ALL_SIDES_ROUNDED_CORNER_SHAPE){
                            val color by animateColorAsState(
                                when (dismissState.targetValue) {
                                    DismissValue.Default -> Color.White
                                    else -> Color.Red
                                }
                            )
                            val alignment = Alignment.CenterEnd
                            val icon = Icons.Default.Delete

                            val scale by animateFloatAsState(
                                if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f
                            )

                            Box(
                                Modifier
                                    .fillMaxSize()
                                    .background(color)
                                    .padding(horizontal = Dp(20f)),
                                contentAlignment = alignment
                            ) {
                                Icon(
                                    icon,
                                    contentDescription = "Delete Icon",
                                    modifier = Modifier.scale(scale),
                                    tint = Color.White
                                )
                            }
                        }
                    },
                    dismissContent = {
                        val color : MutableState<Color> = remember{ mutableStateOf(MyGreen)}
                        val backgroundColor : MutableState<Color> = remember{ mutableStateOf(Color.White)}
                        var longPress = true
                        Card(
                            modifier = Modifier
                                .pointerInput(Unit){
                                    detectTapGestures(
                                        onLongPress = {
                                            if (longPress) {
                                                viewModel.selectIncome(income)
                                                backgroundColor.value = MyGreen
                                                color.value = Color.White
                                                topBarState.value = TopBarType.Delete
                                            }else{
                                                viewModel.unselectIncome(income)
                                                backgroundColor.value = Color.White
                                                color.value = MyGreen
                                                if(viewModel.selectedIncomesCount.value == 0) {
                                                    topBarState.value = TopBarType.Default
                                                }
                                            }
                                            longPress = !longPress
                                        },
                                        onTap = {
                                            coroutineScope.launch {
                                                sheetContent.value = {
                                                    EditIncome(income = income, bottomState = bottomState)
                                                }

                                                bottomState.show()
                                            }
                                        }
                                    )
                                },
                            shape = ALL_SIDES_ROUNDED_CORNER_SHAPE
                        ){
                            IncomeItem(
                                tag = income.tag,
                                description = income.description,
                                date = income.date,
                                value = income.value,
                                color = color,
                                backgroundColor = backgroundColor
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@ExperimentalMaterialApi
@Composable
fun EditIncome(
    income: Income,
    bottomState: ModalBottomSheetState,
    viewModel: CadernetaViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(DEFAULT_PADDING)
    ) {
        val coroutineScope = rememberCoroutineScope()
        var tagText by remember { mutableStateOf(income.tag) }
        var descriptionText by remember { mutableStateOf(income.description) }
        var valueText by remember { mutableStateOf(income.value) }
        var dateText : MutableState<String> = remember{ mutableStateOf(income.date) }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Edição de despesa",
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
                        bottomState.hide()
                    }
                }
            ) {
                Text(text = "CANCELAR")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    val incomeEdited = Income(
                        id = income.id,
                        tag = tagText,
                        description = descriptionText,
                        date = dateText.value,
                        value = valueText
                    )

                    viewModel.addIncome(incomeEdited)

                    coroutineScope.launch {
                        bottomState.hide()
                    }
                }
            ) {
                Text(text = "ADICIONAR")
            }

        }
    }
}