package com.odougle.caderneta.view.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.odougle.caderneta.features.domain.model.Outlay
import com.odougle.caderneta.features.presentation.components.TextField.DateTextField
import com.odougle.caderneta.features.presentation.navigation.BottomBarScreen
import com.odougle.caderneta.features.presentation.screens.CadernetaViewModel
import com.odougle.caderneta.features.presentation.screens.lazycolumns.items.OutlayItem
import com.odougle.caderneta.features.presentation.util.ALL_SIDES_ROUNDED_CORNER_SHAPE
import com.odougle.caderneta.features.presentation.util.DEFAULT_PADDING
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun OutlayScreen(
    viewModel: CadernetaViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    sheetContent: MutableState<(@Composable () -> Unit)>,
    bottomState: ModalBottomSheetState
) {
    val outlayList = viewModel.outlays.value
    if(outlayList.isEmpty()){
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Você ainda não possui despesa, isso é ótimo!")
        }
    }else{
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentPadding = paddingValues
        ) {

            items(outlayList, { outlay: Outlay -> outlay.id }) { outlay ->
                val dismissState = rememberDismissState()
                if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                    viewModel.deleteOutlay(outlay)
                }
                val coroutineScope = rememberCoroutineScope()
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
                        Card(
                            modifier = Modifier
                                .clickable {
                                    coroutineScope.launch {
                                        sheetContent.value = {
                                            EditOutlay(
                                                outlay = outlay,
                                             bottomState = bottomState
                                            )
                                        }
                                        bottomState.show()
                                    }
                                },
                            shape = ALL_SIDES_ROUNDED_CORNER_SHAPE
                        ){
                            OutlayItem(
                                tag = outlay.tag,
                                description = outlay.description,
                                date = outlay.date,
                                value = outlay.value
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun EditOutlay(
    outlay: Outlay,
    viewModel: CadernetaViewModel = hiltViewModel(),
    bottomState: ModalBottomSheetState
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(DEFAULT_PADDING)
    ) {
        val coroutineScope = rememberCoroutineScope()
        var tagText by remember { mutableStateOf(outlay.tag) }
        var descriptionText by remember { mutableStateOf(outlay.description) }
        var valueText by remember { mutableStateOf(outlay.value) }
        var dateText : MutableState<String> = remember{ mutableStateOf(outlay.date) }

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
                    val outlayEdited = Outlay(
                        id = outlay.id,
                        tag = tagText,
                        description = descriptionText,
                        date = dateText.value,
                        value = valueText
                    )

                    viewModel.addOutlay(outlayEdited)

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